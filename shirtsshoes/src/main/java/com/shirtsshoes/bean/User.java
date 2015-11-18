/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirtsshoes.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Rajes
 */
@Entity
@Table(name = "DEMO_USERS")
public class User implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -5559240845888280330L;

	@Id @Column(name = "USER_ID")
    private int id;
    
    @Column(name = "USER_NAME")
    private String userName;
    
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATED_ON")
    private Date createdOn;
    
    @Column(name = "QUOTA")
    private Integer quota;
    
    @Column(name = "PRODUCTS")
    @Type(type ="yes_no")
    private boolean products;
    
    @Column(name = "EXPIRES_ON")
    private Date expiresOn;
    
    @Column(name = "ADMIN_USER")
    @Type(type ="yes_no")
    private boolean adminUser;
    
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<Order>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public boolean isProducts() {
        return products;
    }

    public void setProducts(boolean products) {
        this.products = products;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    public boolean isAdminUser() {
        return adminUser;
    }

    public void setAdminUser(boolean adminUser) {
        this.adminUser = adminUser;
    }

    
    
    
}
