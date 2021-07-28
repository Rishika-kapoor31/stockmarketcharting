package com.stock.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.stockExchangeDao;
import com.stock.dto.stockExchangeDto;
import com.stock.model.StockExchange;


@RestController
@CrossOrigin(origins="http://localhost/4200")
public class StockExchangeController {

	@Autowired
	stockExchangeDao stockExchangeDao;
	
	Logger logger = LoggerFactory.getLogger(StockExchangeController.class);
	
	@GetMapping("/admin/stockexchanges")
	ResponseEntity<?> getStockExchanges(){
		return ResponseEntity.ok(stockExchangeDao.findAll()); 		
	}

	

	
	@PostMapping("/admin/stockexchanges/add")
	@Transactional
	ResponseEntity<?> addStockExchange(@Validated @RequestBody StockExchange sname){
		logger.info(sname.toString());
		stockExchangeDao.save(sname);
		return ResponseEntity.ok(sname.toString());
	}
	
	@GetMapping("admin/stockexchanges/{pattern}")
	ResponseEntity<?> getAllStockExchangeMatching(@PathVariable String pattern){
		return ResponseEntity.ok(stockExchangeDao.findByStockExchangeNameIgnoreCaseContaining(pattern));
	}
	
	@GetMapping("/admin/stockexchanges/get/{seName}")
	ResponseEntity<?> getByStockExchangeName(@PathVariable String seName){

		return ResponseEntity.ok(stockExchangeDao.getByStockExchangeName(seName)); 		
	}
}
