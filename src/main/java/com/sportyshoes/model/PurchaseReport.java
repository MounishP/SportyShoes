package com.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class PurchaseReport {
	
    public PurchaseReport() {
		
	}
	public PurchaseReport(int id, String purchasedBy, String category, Date date) {
        super();
        this.id = id;
        this.purchasedBy = purchasedBy;
        this.category = category;
        this.date = date;
    }

    @Id @GeneratedValue
    private int id;
    private String purchasedBy;
    private String category;
    private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPurchasedBy() {
		return purchasedBy;
	}
	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
