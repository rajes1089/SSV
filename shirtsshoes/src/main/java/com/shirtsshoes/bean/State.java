/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirtsshoes.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rajes
 */
@Entity
@Table(name = "DEMO_STATES")
public class State implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4834669279316882581L;

	@Id
    @Column(name = "ST")
    private String st;
    
    @Column(name = "STATE_NAME")
    private String stateName;

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    
    
}
