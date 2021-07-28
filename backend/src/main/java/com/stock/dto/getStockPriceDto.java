package com.stock.dto;

import java.time.LocalDate;

import com.stock.model.StockExchange;

public class getStockPriceDto {
	private String company;
	private StockExchange stockExchange;
	private String fromDate;
	private String toDate;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public StockExchange getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "getStockPriceDto [company=" + company + ", stockExchange=" + stockExchange + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	public getStockPriceDto(String company, StockExchange stockExchange, String fromDate, String toDate) {
		super();
		this.company = company;
		this.stockExchange = stockExchange;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public getStockPriceDto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
