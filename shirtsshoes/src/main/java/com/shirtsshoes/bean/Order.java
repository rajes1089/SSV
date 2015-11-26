/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirtsshoes.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rajes
 */

public class Order implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4620501340087139820L;

    private int id;
    
//    @Column(name = "CUSTOMER_ID")
//    private int custId;
    
    private BigDecimal total;
    
    private Date timeStamp;
    
    
    private Customer customer;
    
    private User user;
  
    
    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getCustId() {
//        return custId;
//    }
//
//    public void setCustId(int custId) {
//        this.custId = custId;
//    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    
}
