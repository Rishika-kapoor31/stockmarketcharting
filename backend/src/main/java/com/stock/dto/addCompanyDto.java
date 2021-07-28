package com.stock.dto;

import java.util.Arrays;

public class addCompanyDto {
	private companyDto companyDto;
	private stockCodeDto[] stockCodeDtos;
	
	
	
	public addCompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public addCompanyDto(com.stock.dto.companyDto companyDto,
			stockCodeDto[] stockCodeDtos) {
		super();
		this.companyDto = companyDto;
		this.stockCodeDtos = stockCodeDtos;
	}


	public companyDto getCompanyDto() {
		return companyDto;
	}


	public void setCompanyDto(companyDto companyDto) {
		this.companyDto = companyDto;
	}


	public stockCodeDto[] getStockCodeDtos() {
		return stockCodeDtos;
	}


	public void setStockCodeDtos(stockCodeDto[] stockCodeDtos) {
		this.stockCodeDtos = stockCodeDtos;
	}


	@Override
	public String toString() {
		return "addCompanyDto [companyDto=" + companyDto + ", stockCodeDtos=" + Arrays.toString(stockCodeDtos) + "]";
	}
	
	
}