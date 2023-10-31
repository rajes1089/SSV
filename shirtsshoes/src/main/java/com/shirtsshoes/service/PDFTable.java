import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableDrawer {

    class Cell {
        String text;
        String color;
        int fontSize;
    }

    class Row {
        List<Cell> cells;
    }

    /**
     * Draws a table using Apache PDFBox.
     *
     * @param filePath      Path where the PDF will be saved.
     * @param columnTitles  List of column titles.
     * @param rows          List of rows, each containing a list of cells.
     */
    public void drawTable(String filePath, List<String> columnTitles, List<Row> rows) {
        try (PDDocument document = new PDDocument()) {
            // Calculate the number of rows that can fit on a single page
            int rowsPerPage = calculateRowsPerPage(document, columnTitles, rows);

            // Split the rows into pages
            List<List<Row>> pagesOfRows = splitRowsIntoPages(rows, rowsPerPage);

            // Create a page for each set of rows
            for (List<Row> pageRows : pagesOfRows) {
                PDPage page = new PDPage();
                document.addPage(page);

                drawTableOnPage(document, page, columnTitles, pageRows);
            }

            // Save the document to the specified file path
            document.save(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateRowsPerPage(PDDocument document, List<String> columnTitles, List<Row> rows) {
        PDPage testPage = new PDPage();
        try (PDPageContentStream contentStream = new PDPageContentStream(document, testPage)) {
            float margin = 50;
            float yStart = testPage.getMediaBox().getHeight() - margin;
            float rowHeight = 15f;

            // Draw column titles
            float yTextPosition = yStart - 15;
            for (String title : columnTitles) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(margin, yTextPosition);
                contentStream.showText(title);
                contentStream.endText();
                yTextPosition -= 15;
            }

            // Draw one row to measure its height
            drawTableRow(contentStream, margin, yStart, rowHeight, rows.get(0).cells);

            // Calculate the height of one row
            float singleRowHeight = yStart - yTextPosition;

            // Calculate the number of rows that can fit on a single page
            return (int) ((testPage.getMediaBox().getHeight() - 2 * margin) / singleRowHeight);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void drawTableOnPage(PDDocument document, PDPage page, List<String> columnTitles, List<Row> rows) {
        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float rowHeight = 15f;

            // Draw column titles
            float yTextPosition = yStart - 15;
            for (String title : columnTitles) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(margin, yTextPosition);
                contentStream.showText(title);
                contentStream.endText();
                yTextPosition -= 15;
            }

            // Draw table content
            for (Row row : rows) {
                // Draw each row
                drawTableRow(contentStream, margin, yStart, rowHeight, row.cells);
                yStart -= rowHeight;
            }

            // Draw table borders
            float tableYBottom = yStart;
            contentStream.setLineWidth(1f);
            contentStream.moveTo(margin, yStart);
            contentStream.lineTo(margin, tableYBottom);
            contentStream.lineTo(margin + calculateTableWidth(page), tableYBottom);
            contentStream.stroke();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawTableRow(PDPageContentStream contentStream, float xStart, float yStart, float rowHeight, List<Cell> cells) throws IOException {
        float xPosition = xStart;

        for (Cell cell : cells) {
            // Set color and font for each cell
            contentStream.setNonStrokingColor(Color.decode(cell.color));
            contentStream.setFont(PDType1Font.HELVETICA, cell.fontSize);

            // Draw text in each cell
            contentStream.beginText();
            contentStream.newLineAtOffset(xPosition, yStart - 15);
            contentStream.showText(cell.text);
            contentStream.endText();

            xPosition += calculateTableWidth(contentStream.getCurrentPage()) / cells.size();
        }
    }

    private float calculateTableWidth(PDPage page) {
        return page.getMediaBox().getWidth() - 2 * 50; // 50 is the margin on both sides
    }

    private List<List<Row>> splitRowsIntoPages(List<Row> rows, int rowsPerPage) {
        List<List<Row>> pages = new ArrayList<>();
        int pageCount = (int) Math.ceil((double) rows.size() / rowsPerPage);

        for (int i = 0; i < pageCount; i++) {
            int fromIndex = i * rowsPerPage;
            int toIndex = Math.min((i + 1) * rowsPerPage, rows.size());
            pages.add(rows.subList(fromIndex, toIndex));
        }

        return pages;
    }

    public static void main(String[] args) {
        // Example usage
        TableDrawer tableDrawer = new TableDrawer();
        List<String> columnTitles = Arrays.asList("Date", "Debit/Credit", "Transaction Description", "Amount", "Ledger Balance");
        List<Row> rows = new ArrayList<>();

        // Sample data for rows
        for (int i = 1; i <= 15; i++) {
            Row row = new Row();
            row.cells = Arrays.asList(
                    createCell("2023-01-" + i, "#000000", 10),
                    createCell(i % 2 == 0 ? "Debit" : "Credit", i % 2 == 0 ? "#FF0000" : "#00FF00", 10),
                    createCell("Transaction " + i, "#000000", 10),
                    createCell("$" + (i * 10) + ".00", "#000000", 10),
                    createCell("$" + (i * 50) + ".00", "#000000", 10)
            );
            rows.add(row);
        }

        // Specify the path where the PDF will be