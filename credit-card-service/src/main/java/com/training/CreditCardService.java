package com.training;

public class CreditCardService {

	private CreditCard[] arrayCard=new CreditCard[maxCount];
	
	static int maxCount=10; 
	private int itr=0;
	public boolean addCard(CreditCard card) {
		boolean flag=false;
			if(itr<maxCount) {
				arrayCard[itr]=card;
				itr++;
				flag=true;
			}
		return flag;
	}
	public CreditCard[] getCards() {
		
		return arrayCard;
		
	}
}