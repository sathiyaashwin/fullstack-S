package com.training.model;

public class Product {
	
	private int productId;
	private String productname;
	private int ratePerUnit;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(int ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productname, int ratePerUnit) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.ratePerUnit = ratePerUnit;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productname=" + productname + ", ratePerUnit=" + ratePerUnit
				+ "]";
	}
	
}
