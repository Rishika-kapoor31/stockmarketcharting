package com.stock.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"companyName"})},schema = "targetSchemaName")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String companyName;
	
	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity = Sector.class)
	private Sector sector;
	
	private String ceo;
	
	private Long turnover;
	
	private String boardOfDirectors;
	
	private String details;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
	@JsonIgnore
	private IPO ipo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="company_id")
	private List<CompanyStockExchangeMap> stockCodes = new ArrayList<>();

	public IPO getIpo() {
		return ipo;
	}

	public void setIpo(IPO ipo) {
		this.ipo = ipo;
	}
	public long getId() {
		return id;
	}

	public Company() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}


	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public Long getTurnover() {
		return turnover;
	}

	public void setTurnover(Long turnover) {
		this.turnover = turnover;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<CompanyStockExchangeMap> getStockCodes() {
		return stockCodes;
	}

	public void setStockCodes(List<CompanyStockExchangeMap> stockCodes) {
		this.stockCodes = stockCodes;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", sector=" + sector + ", ceo=" + ceo
				+ ", turnover=" + turnover + ", boardOfDirectors=" + boardOfDirectors + ", details="
				+ details + ", stockCodes=" + stockCodes + "]";
	}

}

