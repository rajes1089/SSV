/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shirtsshoes.bean;

import java.io.Serializable;

/**
 *
 * @author Rajes
 */
public class State implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4834669279316882581L;

    private String st;
    
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
