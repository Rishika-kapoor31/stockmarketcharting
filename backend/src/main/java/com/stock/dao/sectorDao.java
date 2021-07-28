
package com.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.Sector;



public interface sectorDao extends JpaRepository<Sector, Long>{
	
	public Sector getBySectorName(String sectorName);

}
