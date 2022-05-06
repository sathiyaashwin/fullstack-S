package com.example.entity;

public class Invoice {
	
	private int invoice_number;
	private String customer_name;
	private int quantity;
	private int product_ref;
	
	public int getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(int invoice_number) {
		this.invoice_number = invoice_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProduct_ref() {
		return product_ref;
	}
	public void setProduct_ref(int product_ref) {
		this.product_ref = product_ref;
	}
	public Invoice(int invoice_number, String customer_name, int quantity, int product_ref) {
		super();
		this.invoice_number = invoice_number;
		this.customer_name = customer_name;
		this.quantity = quantity;
		this.product_ref = product_ref;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Invoice [invoice_number=" + invoice_number + ", customer_name=" + customer_name + ", quantity="
				+ quantity + ", product_ref=" + product_ref + "]";
	}
	
	
	
	

}
