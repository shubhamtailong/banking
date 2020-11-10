package com.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Accounts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNum;
	
	private double balance;
	
	
	private int customerId;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	private String IFSC;
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getIFSC() {
		return IFSC;
	}


	public Accounts(int accountNum, double balance, int customerId, Customer customer, String iFSC) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
		this.customerId = customerId;
		this.customer = customer;
		IFSC = iFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Accounts [accountNum=" + accountNum + ", balance=" + balance + ", customerId=" + customerId
				+ ", customer=" + customer + ", IFSC=" + IFSC + "]";
	}
	public Accounts() {
		super();
	}
	
	
	

}
