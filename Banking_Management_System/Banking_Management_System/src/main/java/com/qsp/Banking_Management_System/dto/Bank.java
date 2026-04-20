package com.qsp.Banking_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private String bankEmail;
	private long bankPhone;
	private String bankType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchs;
	@OneToOne(cascade = CascadeType.ALL)
	private Manager manager;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Atm> atms;

	public List<Atm> getAtms() {
		return atms;
	}

	public void setAtms(List<Atm> atms) {
		this.atms = atms;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankEmail() {
		return bankEmail;
	}

	public void setBankEmail(String bankEmail) {
		this.bankEmail = bankEmail;
	}

	public long getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(long bankPhone) {
		this.bankPhone = bankPhone;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

}
