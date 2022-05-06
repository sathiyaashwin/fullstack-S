package com.example.entity;

public class LoanApplication {
	
	private int loanApplicationNumber;
	private Customer customer;
	private double loanAmount;
	
	public int getLoanApplicationNumber() {
		return loanApplicationNumber;
	}
	public void setLoanApplicationNumber(int loanApplicationNumber) {
		this.loanApplicationNumber = loanApplicationNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanApplication(int loanApplicationNumber, Customer customer, double loanAmount) {
		super();
		this.loanApplicationNumber = loanApplicationNumber;
		this.customer = customer;
		this.loanAmount = loanAmount;
	}
	@Override
	public String toString() {
		return "LoanApplication [loanApplicationNumber=" + loanApplicationNumber + ", customer=" + customer
				+ ", loanAmount=" + loanAmount + "]";
	}
	

	
}
