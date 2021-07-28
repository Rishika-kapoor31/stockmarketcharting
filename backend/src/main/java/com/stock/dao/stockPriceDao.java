package com.stock.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.Company;
import com.stock.model.StockExchange;
import com.stock.model.StockPrice;


public interface stockPriceDao extends JpaRepository<StockPrice, Long> {
	public List<StockPrice> findByCompanyAndStockExchangeAndDateBetween(Company company,StockExchange se,LocalDate date1, LocalDate date2);
}