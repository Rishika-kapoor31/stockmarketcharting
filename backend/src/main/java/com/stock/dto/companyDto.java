package com.stock.dto;

import javax.persistence.Entity;

public class companyDto {
	
	private String companyName;
	private String sector;
	private String stockExchanges;
	private String ceo;
	private Long turnover;
	private String boardOfDirectors;
	private String details;
	


	@Override
	public String toString() {
		return "companyDto [companyName=" + companyName + ", sector=" + sector + ", stockExhanges=" + stockExchanges
				+ ", ceo=" + ceo + ", turnover=" + turnover + ", boardOfDirectors=" + boardOfDirectors + ", details="
				+ details + "]";
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(String stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public Long getTurnover() {
		return turnover;
	}

	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public companyDto() {
//		super();
		// TODO Auto-generated constructor stub
	}
	

	public companyDto(String companyName, String sector, String stockExchanges, String ceo, Long turnover,
			String boardOfDirectors, String details) {
//		super();
		this.companyName = companyName;
		this.sector = sector;
		this.stockExchanges = stockExchanges;
		this.ceo = ceo;
		this.turnover = turnover;
		this.boardOfDirectors = boardOfDirectors;
		this.details = details;
	}


	
}
