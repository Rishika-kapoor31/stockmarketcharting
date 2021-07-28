package com.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="company_stockexchange",schema = "targetSchemaName")
public class CompanyStockExchangeMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "company_code")
	private String companyCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="company_id", insertable = false, updatable = false)
	@JsonIgnore
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(as = StockExchange.class)
	private StockExchange stockExchange;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public CompanyStockExchangeMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CompanyStockExchangeMap [id=" + id + ", companyCode=" + companyCode 
				+ ", stockExchange=" + stockExchange + "]";
	}
	
	
}