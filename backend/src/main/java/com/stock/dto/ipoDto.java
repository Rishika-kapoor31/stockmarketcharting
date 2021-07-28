package com.stock.dto;

public class ipoDto {
	private String companyName;
	private String stockExchanges;
	private Long pricePerShare;
    private Long totalNumberOfShare;
    private String openDateTime;
    private String remarks;
    
   
    public ipoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public Long getPricePerShare() {
		return pricePerShare;
	}
	public Long getTotalNumberOfShares() {
		return totalNumberOfShare;
	}
	public String getOpenDateTime() {
		return openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	
	

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setPricePerShare(Long pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public void setTotalNumberOfShares(Long totalNumberOfShare) {
		this.totalNumberOfShare = totalNumberOfShare;
	}
	public void setOpenDateTime(String openDateTime) {
		this.openDateTime = openDateTime;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(String stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	@Override
	public String toString() {
		return "ipoDto [companyName=" + companyName + ", stockExchanges=" + stockExchanges + ", pricePerShare="
				+ pricePerShare + ", totalNumberOfShares=" + totalNumberOfShare + ", openDateTime=" + openDateTime
				+ ", remarks=" + remarks + "]";
	}

	public ipoDto(String companyName, String stockExchanges, Long pricePerShare, Long totalNumberOfShares,
			String openDateTime, String remarks) {
		super();
		this.companyName = companyName;
		this.stockExchanges = stockExchanges;
		this.pricePerShare = pricePerShare;
		this.totalNumberOfShare = totalNumberOfShare;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}


    
    
}
