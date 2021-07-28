package com.stock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.model.Company;
import com.stock.model.Sector;


@Repository
public interface companyDao extends JpaRepository<Company,Long>{


	public Company getByCompanyName(String companyName);
	public List<Company> findByCompanyNameIgnoreCaseContaining(String companyName);
	public List<Company> findBySector(Sector sector);
	
	@Query(value="SELECT * FROM database.company c where sector_id= ?1",  nativeQuery = true)
	public List<Company> findBySectorId(Long sectorId);
}
