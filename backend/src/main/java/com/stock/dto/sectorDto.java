package com.stock.dto;

public class sectorDto {
	
	private Long id;
	private String sectorName;
	private String brief;
	@Override
	public String toString() {
		return "sectorDto [id=" + id + ", sectorName=" + sectorName + ", brief=" + brief + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public sectorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sectorDto(String sectorName, String brief) {
		super();
		this.sectorName = sectorName;
		this.brief = brief;
	}
	
	
}