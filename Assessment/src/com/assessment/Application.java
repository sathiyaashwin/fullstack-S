package com.assessment;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		String[] str = new String[n];
		System.out.println("Enter the String elements");
		for(int i=0;i< n;i++) {
			str[i]=sc.next();
		}
	
		FruitService fruitService=new FruitService();
		fruitService.add(str);
		sc.close();

	}

}