package com.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.StockExchange;

@Repository
public interface stockExchangeDao extends JpaRepository<StockExchange, Long>{

	public StockExchange getByStockExchangeName(String stockExchangeName);
	public List<StockExchange> findByStockExchangeNameIgnoreCaseContaining(String pattern);
	
}
