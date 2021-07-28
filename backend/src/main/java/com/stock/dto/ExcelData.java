package com.stock.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ExcelData{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String companyCode;
	private String stockExchange;
	private int pricePerShare;
	private LocalDate date; 
	private LocalTime time;
    
	public ExcelData(String companyCode, String stockExchange, Integer pricePerShare, String date, String time) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.date = LocalDate.parse(date);
		this.time = LocalTime.parse(time);
	}

	@Override
	public String toString() {
		return "ExcelData [companyCode=" + companyCode + ", stockExchange=" + stockExchange + ", pricePerShare="
				+ pricePerShare + ", date=" + date + ", time=" + time + "]";
	}

	public ExcelData() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Integer getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double d) {
		this.pricePerShare = (int) d;
	}

	public LocalDate getDate() {
		return date;
	}

//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	public LocalTime getTime() {
		return time;
	}

//	public void setTime(LocalTime time) {
//		this.time = time;
//	}
	
	public void setDate(Date date2) {
		this.date = LocalDate.parse((CharSequence) date2);
	}
	public void setTime(String time) {
		this.time = LocalTime.parse(time);
	}

	
	
}
    
