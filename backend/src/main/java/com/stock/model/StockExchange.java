package com.stock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class StockExchange {

	@Id
	@GeneratedValue
	private long id;

	private String stockExchangeName;
	
	private String brief;
	private String contactAddress;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private String remarks;

	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchangeName=" + stockExchangeName + ", brief=" + brief
				+ ", contactAddress=" + contactAddress + ", remarks=" + remarks + "]";
	}
	public StockExchange() {

	}
}
