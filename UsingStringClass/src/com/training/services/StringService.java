package com.training.services;

public class StringService {
	
	public void stringEquals(String str1,String str2)
	{
		System.out.println("Is Values Same :- "+str1.equals(str2));
		System.out.println("Are they Pointing to same location :- "+(str1==str2));
	}
	
	public void stringObjectEquals() {
		
		String vish = new String("Vishnu");
		String gowse = new String("Vishnu");
		
		System.out.println("Is Values Same :- "+vish.equals(gowse));
		System.out.println("Are they Pointing to same location :- "+(vish==gowse));
	}
	
	public String usingTrim(String name) {
		
		System.out.println("wihtour trim :-"+name);
		System.out.println("Trim :-"+name.trim());
		return name.trim();
	}
	
	public void lengthOfString(String name) {
		
		String resp=usingTrim(name);
		System.out.println("String Length :- "+name.length());
		
	}
	
	public void usingSubString(String name) {
		
		 System.out.println(name.substring(3));
		 System.out.println(name.substring(0,4));
	}
	public void usingChartAtAndIndexOf(String name) {
		
		System.out.println("Index position of @ :- "+ name.indexOf('@'));
		System.out.println("Character At position 6 :- "+name.charAt(6));
	}
	
	public void usingReplace(String str1,String str2) {
		
		System.out.println(str1.replace(".com", ".org"));
		System.out.println(str2.replace('h','e'));
	}
	public void usingConcat(String str1,String str2) {
		
		// String is immutable - Cannot be changed
		System.out.println(str1.concat(str2));
		
		// String builder is mutable - Can be changed
 		StringBuilder builder = new StringBuilder(str1);
		builder.append(str2);
		System.out.println(builder.toString());
	}
	
	public void usingCompareTo(String str1, String str2) {
		
		System.out.println(str1.compareTo(str2));
	}
	public void usingStringFormat(String str1 , double mark) {
		
		String firstString = String.format("Name %S", str1);
		System.out.println(firstString);
		
		System.out.println(String.format("Mark %.2f",mark));
	}
	public void usingStringFormat(double mark) {
		
		System.out.println(String.format("Octal %o", mark));
		System.out.println(String.format("Hexa Decimal %x", mark));
	}
	public void usingStringFormat(int mark1,int mark2) {
		
		System.out.println(String.format("Octal %1$o,Hexa %2$x", mark1,mark2));
	}
	public void usingStringFormat(String str1,String str2) {
		
		System.out.println(String.format(" %1$s,|%2$S", str1,str2));
	}
	
}
