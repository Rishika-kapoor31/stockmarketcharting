package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stock.dao.sectorDao;
import com.stock.dto.sectorDto;
import com.stock.model.Company;
import com.stock.model.Sector;

@RestController
@CrossOrigin(origins="http://localhost/4200")
public class SectorController {
	
	@Autowired
	sectorDao sectorDao;
	
	@Autowired
	com.stock.dao.companyDao companyDao;
	
	@GetMapping("user/sector/{sectorName}")
	ResponseEntity<?> getCompaniesBySector(@PathVariable String sectorName){
		Sector sector = sectorDao.getBySectorName(sectorName);
		return ResponseEntity.ok(companyDao.findBySectorId(sector.getId()));
	}
	
	@PostMapping("admin/sectors/add")
	ResponseEntity<?> addSector(@RequestBody sectorDto sectorDto){
		Sector sector = new  Sector();
		sector.setSectorName(sectorDto.getSectorName());
		sector.setBrief(sectorDto.getBrief());
		sectorDao.save(sector);
		return ResponseEntity.ok(sector);
	}
	
	@GetMapping("admin/sectors")
	ResponseEntity<?> getAllSectors(){
		return ResponseEntity.ok(sectorDao.findAll());
	}
	
}
