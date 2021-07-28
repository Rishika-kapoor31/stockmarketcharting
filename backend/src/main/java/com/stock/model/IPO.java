package com.stock.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class IPO {

	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne 
	private Company company;
	
	@ManyToMany
	@JoinTable(name = "ipo_stockexchange", schema = "targetSchemaName")
	@JsonSerialize(contentAs = StockExchange.class)
	private List<StockExchange> stockExchanges =new ArrayList<>() ;
	
	private Long pricePerShare;
	
	private Long totalNumberOfShare;
	private LocalDateTime openDateTime;
	private String remarks;
	
	
	public long getId() {
		return id;
	}
	public Company getCompany() {
		return company;
	}
	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}
	public Long getPricePerShare() {
		return pricePerShare;
	}
	public Long getTotalNumberOfShare() {
		return totalNumberOfShare;
	}
	public LocalDateTime getOpenDateTime() {
		return openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public void setStockExchanges(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}
	public void setPricePerShare(Long pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public void setTotalNumberOfShare(Long totalNumberOfShare) {
		this.totalNumberOfShare = totalNumberOfShare;
	}
	public void setOpenDateTime(LocalDateTime openDateTime) {
		this.openDateTime = openDateTime;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "IPO [id=" + id + ", company=" + company + ", stockExchanges=" + stockExchanges + ", pricePerShare="
				+ pricePerShare + ", totalNumberOfShare=" + totalNumberOfShare + ", openDateTime=" + openDateTime
				+ ", remarks=" + remarks + "]";
	}
	
	
}

/* 2. Company Name
3. Stock Exchange
4. Price per share
5. Total number of Shares
6. Open Date Time
7. Remarks*/