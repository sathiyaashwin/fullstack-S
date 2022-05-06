package com.training.services;

import com.training.model.Product;

public class ApplicationProduct {

	public static void main(String[] args) {
		
		Product prd1 = new Product(101,"Gowsick",800);
		Product prd2 = new Product(102,"Vishnu",300);
		Product prd3 = new Product(103,"Yovel",700);
		Product prd4 = new Product(104,"location",1000);
		Product prd5 = new Product(105,"abisheik",600);
		Product prd6 = new Product(106,"gokul",400);
		Product prd7 = new Product(107,"harish",200);
		Product prd8 = new Product(108,"dhanush",100);
		
		System.out.println(prd1);
		System.out.println(prd2);
		System.out.println(prd3);
		System.out.println(prd4);
		System.out.println(prd5);
		System.out.println(prd6);
		System.out.println(prd7);
		System.out.println(prd8);
		System.out.println();
		System.out.println("------------------------Top Three-------------------------");
		System.out.println();
		System.out.println(prd4);
		System.out.println(prd1);
		System.out.println(prd3);

	}

}
