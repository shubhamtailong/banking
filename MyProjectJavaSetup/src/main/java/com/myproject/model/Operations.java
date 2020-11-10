package com.myproject.model;

public class Operations {
private int id;
private String password;
private double balance;
private String opType;
public String getOpType() {
	return opType;
}
public void setOpType(String opType) {
	this.opType = opType;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "Operations [id=" + id + ", password=" + password + ", balance=" + balance + ", opType=" + opType + "]";
}


	
}
