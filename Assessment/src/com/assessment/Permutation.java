package com.assessment;

import java.util.Scanner;

public class Permutation {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String which should be Permutated : ");
		String str=sc.nextLine();
		int len=str.length();
		
		Process process= new Process();
		process.permute(str, 0, len-1);	
		sc.close();
	}

}


