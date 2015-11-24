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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Rajes
 */

@Entity
@Table(name = "DEMO_ORDERS")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value={"customer","user"})
public class Order implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4620501340087139820L;

	@Id
    @Column(name = "ORDER_ID")
    private int id;
    
//    @Column(name = "CUSTOMER_ID")
//    private int custId;
    
    @Column(name = "ORDER_TOTAL")
    private BigDecimal total;
    
    @Column(name = "ORDER_TIMESTAMP")
    private Date timeStamp;
    
    
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID",nullable = false)
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;
  
    
    @OneToMany(mappedBy = "order",fetch=FetchType.EAGER)
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
