package com.training;


public class CreditCard {

	private long cardNumber;
	private String cardHolderName;
	private long amountDue;
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditCard(long cardNumber, String cardHolderName, long amountDue) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.amountDue = amountDue;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public long getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(long amountDue) {
		this.amountDue = amountDue;
	}
	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", amountDue="
				+ amountDue + "]";
	}
	
	
}