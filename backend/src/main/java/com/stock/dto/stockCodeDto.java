package com.stock.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class stockCodeDto {
	private String stockCode;
	private String stockExchange;
	
	


	public stockCodeDto() {
		super();
	}

	public stockCodeDto(String stockCode, String stockExchange) {
		super();
		this.stockCode = stockCode;
		this.stockExchange = stockExchange;
	}

	@Override
	public String toString() {
		return "stockCodeDto [stockCode=" + stockCode + ", stockExchange=" + stockExchange + "]";
	}
	
	public String getStockCode() {
		return stockCode;
	}
	
	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	
	
}
