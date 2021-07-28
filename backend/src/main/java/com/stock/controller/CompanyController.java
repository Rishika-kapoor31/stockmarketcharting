package com.stock.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dao.companyDao;
import com.stock.dao.companyStockExchangeDao;
import com.stock.dao.sectorDao;
import com.stock.dao.stockExchangeDao;
import com.stock.dao.stockPriceDao;
import com.stock.dto.addCompanyDto;
import com.stock.dto.companyDto;
import com.stock.dto.getStockPriceDto;
import com.stock.dto.stockCodeDto;
import com.stock.model.Company;
import com.stock.model.CompanyStockExchangeMap;
import com.stock.model.Sector;
import com.stock.model.StockExchange;
import com.stock.model.StockPrice;

@RestController
@CrossOrigin(origins="http://localhost/4200")
public class CompanyController {
	
	@Autowired
	companyDao companyDao;
	
	@Autowired
	stockExchangeDao stockExchangeDao;
	
	@Autowired
	stockPriceDao stockPriceDao;
	
	@Autowired
	sectorDao sectorDao;
	Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@GetMapping("admin/companies/sector/{sectorId}")
	ResponseEntity<?> getBySector(@PathVariable Long sectorId){
		return ResponseEntity.ok(companyDao.findBySectorId(sectorId));
	}
	

	@GetMapping("admin/companies")
	ResponseEntity<?> getAllCompanies(){
		//System.out.println(companyDao.findAll());
		return ResponseEntity.ok(companyDao.findAll());
	}
	
	@GetMapping("admin/companies/{pattern}")
	ResponseEntity<?> getAllCompaniesMatching(@PathVariable String pattern){
		//System.out.println(companyDao.findByCompanyNameIgnoreCaseContaining(pattern));
		return ResponseEntity.ok(companyDao.findByCompanyNameIgnoreCaseContaining(pattern));
	}

	@GetMapping("user/companies")
	ResponseEntity<?> getAllCompany(){
		//sSystem.out.println(companyDao.findAll());
		return ResponseEntity.ok(companyDao.findAll());
	}
	
	@GetMapping("user/companies/{pattern}")
	ResponseEntity<?> getAllCompaniesMatchingUser(@PathVariable String pattern){
		System.out.println(companyDao.findByCompanyNameIgnoreCaseContaining(pattern));
		return ResponseEntity.ok(companyDao.findByCompanyNameIgnoreCaseContaining(pattern));
	}
	
	@DeleteMapping("/admin/companies/delete/{id}")
	ResponseEntity<?> deleteCompany(@PathVariable Long id){
		logger.info("delete "+id);
		companyDao.deleteById(id);
		return ResponseEntity.ok("deleted");
	}
 	
	@PutMapping("/admin/companies/update/{id}")
	ResponseEntity<?> updateCompany( @Validated @RequestBody addCompanyDto addCompanyDto, @PathVariable Long id){
		String response="";
		try{
			Company oldCompany = companyDao.getById(id);
			companyDto companyDto = addCompanyDto.getCompanyDto();
			Company company=new Company();
			company.setId(id);
			company.setSector(sectorDao.getBySectorName(companyDto.getSector()));
			company.setBoardOfDirectors(companyDto.getBoardOfDirectors());
			company.setCeo(companyDto.getCeo());
			company.setCompanyName(companyDto.getCompanyName());
			company.setDetails(companyDto.getDetails());
			company.setTurnover(companyDto.getTurnover());
			
			List<CompanyStockExchangeMap> oldStockCodes =  oldCompany.getStockCodes();
			stockCodeDto[] stockCodeDtos = addCompanyDto.getStockCodeDtos();
			List<CompanyStockExchangeMap> stockCodes = new ArrayList<>();
			for(stockCodeDto scDto:stockCodeDtos) {
				CompanyStockExchangeMap csMap= new CompanyStockExchangeMap();
				csMap.setCompanyCode(scDto.getStockCode());
				StockExchange se =  stockExchangeDao.getByStockExchangeName(scDto.getStockExchange());
				for (CompanyStockExchangeMap oldSc : oldStockCodes) {
					if(se == oldSc.getStockExchange()) csMap.setId(oldSc.getId());
				}
				csMap.setStockExchange(se);
				stockCodes.add(csMap);
				logger.info(csMap.toString());
			}
			company.setStockCodes(stockCodes);
			response=company.toString();
			
			company = companyDao.save(company);
			logger.info(company.toString());
		}catch(Exception e) {
			ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/admin/companies/add")
	ResponseEntity<?> addCompany(@Validated @RequestBody addCompanyDto addCompanyDto) throws  Exception {
		String response="";
		logger.info(addCompanyDto.toString());
		try {
			companyDto companyDto = addCompanyDto.getCompanyDto();
			Company company=new Company();
			company.setSector(sectorDao.getBySectorName(companyDto.getSector()));
			company.setBoardOfDirectors(companyDto.getBoardOfDirectors());
			company.setCeo(companyDto.getCeo());
			company.setCompanyName(companyDto.getCompanyName());
			company.setDetails(companyDto.getDetails());
			company.setTurnover(companyDto.getTurnover());
			stockCodeDto[] stockCodeDtos = addCompanyDto.getStockCodeDtos();
			List<CompanyStockExchangeMap> stockCodes = new ArrayList<>();
			for(stockCodeDto scDto:stockCodeDtos) {
				CompanyStockExchangeMap csMap= new CompanyStockExchangeMap();
				csMap.setCompanyCode(scDto.getStockCode());
				csMap.setStockExchange(stockExchangeDao.getByStockExchangeName(scDto.getStockExchange()));
				stockCodes.add(csMap);
				logger.info(csMap.toString());
			}
			company.setStockCodes(stockCodes);
			response=company.toString();
			company = companyDao.save(company);
			logger.info(company.toString());
		} catch(Exception ex) {
			ResponseEntity.badRequest().body(ex);
			}	
	    return ResponseEntity.ok(response);
	}


	@PostMapping("/user/companies/stockprice")
	ResponseEntity<?> getStockPrice(@RequestBody getStockPriceDto getStockPriceDto){
		logger.info(getStockPriceDto.toString());
		List<StockPrice> stockPriceList = stockPriceDao.findByCompanyAndStockExchangeAndDateBetween(
				companyDao.getByCompanyName(getStockPriceDto.getCompany()),
				getStockPriceDto.getStockExchange(),
				LocalDate.parse(getStockPriceDto.getFromDate()),
				LocalDate.parse(getStockPriceDto.getToDate()));

		return ResponseEntity.ok(stockPriceList);
	}
	
}
