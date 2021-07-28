package com.stock.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.model.CompanyStockExchangeMap;
import com.stock.model.StockExchange;


public interface companyStockExchangeDao extends JpaRepository<CompanyStockExchangeMap, Long>{
	
	public CompanyStockExchangeMap getByCompanyCodeAndStockExchange(String companyCode, StockExchange stockExchange);
}
