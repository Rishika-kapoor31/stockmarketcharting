package com.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Authuser {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private String username;

	private String password;
	private Role userType =  Role.USER;
	
	@Column(unique = true)
	private String email;
	
	private String mobileNumber;
	
	private boolean confirmed = false;

	public Authuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authuser(Integer id, String username, String password, Role userType, String email, String mobileNumber,
			boolean confirmed) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmed = confirmed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserType() {
		return userType;
	}

	public void setUserType(Role userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	

	
}
