package com.myproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Customer")
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId", referencedColumnName = "customerId")
	private Accounts account;
	
	public Accounts getAccount() {
		return account;
	}


	public void setAccount(Accounts account) {
		this.account = account;
	}



	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	private String firstName;
	


	private String lastName;
	private String emailId;
	private long phoneNumber;
	private String panNumber;
	private String dob;
	private String city;
	private String password;
	
	
	
	

	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	


	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", account=" + account + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", panNumber="
				+ panNumber + ", dob=" + dob + ", city=" + city + ", password=" + password + "]";
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	


	

	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPassword() {
		return password;
	}





	public Customer(int customerId, Accounts account, String firstName, String lastName, String emailId,
			long phoneNumber, String panNumber, String dob, String city, String password) {
		super();
		this.customerId = customerId;
		this.account = account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.dob = dob;
		this.city = city;
		this.password = password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Customer() {
		
	}
	
	

}
