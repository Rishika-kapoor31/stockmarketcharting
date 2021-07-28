package com.stock.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.stock.dto.ExcelData;
import com.stock.message.ResponseMessage;
import com.stock.model.Company;
import com.stock.model.CompanyStockExchangeMap;
import com.stock.model.StockExchange;
import com.stock.model.StockPrice;



@RestController
@CrossOrigin(origins="http://localhost/4200")
public class ImportDataController {
	
	@Autowired
	com.stock.dao.companyDao companyDao;
	
	@Autowired
	com.stock.dao.stockExchangeDao stockExchangeDao;
	
	@Autowired
	com.stock.dao.stockPriceDao stockPriceDao;
	
	@Autowired
	com.stock.dao.companyStockExchangeDao companyStockExchangeDao;
	
	@Autowired
	com.stock.dao.stockPriceDao stockpricedao;
	
	
	
	Logger logger = LoggerFactory.getLogger(ImportDataController.class); 
	
	
	
	
	
	@PostMapping("/admin/import")
	ResponseEntity<List<Boolean>> ImportData(@Validated @RequestBody ExcelData[] excelData) throws Exception {
        List<Boolean> responseList = new ArrayList<>();
		for(ExcelData e: excelData){
       	try{
			logger.info(e.toString());
        		StockExchange se = stockExchangeDao.getByStockExchangeName(e.getStockExchange());
        		logger.info(se.toString());
        		CompanyStockExchangeMap csMap =companyStockExchangeDao.getByCompanyCodeAndStockExchange(e.getCompanyCode(),
        				se);
        		
        		Company company = csMap.getCompany();
        		StockPrice sPrice = new StockPrice();
        		
        		sPrice.setCompany(company);
        		sPrice.setCurrentPrice(e.getPricePerShare());
        		sPrice.setStockExchange(se);
        		sPrice.setDate(e.getDate());
        		sPrice.setTime(e.getTime());
        		
            	stockPriceDao.save(sPrice);
        		logger.info(sPrice.toString());
        		responseList.add(true);
        	}catch (Exception ex) {
////        		ex.printStackTrace();
        		responseList.add(false);
      		}
        }
        return ResponseEntity.ok(responseList);
    }
}
