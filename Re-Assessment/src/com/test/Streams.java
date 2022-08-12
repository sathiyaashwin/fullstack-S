package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static java.util.stream.Collectors.toList;

public class Streams{
	
	public static void main(String []args) {
		
		List<Stream> tableList = StreamList.strmTable();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Find place from country");
		String a = sc.next();
		
		List<String> listPlace = tableList.stream().filter(r->r.getCountry().equals(a)).map(e->e.getPlace()).collect(toList());
		listPlace.forEach(System.out::println);

		System.out.println("Country with its total count");
		String b = sc.next();
		
		Long total=tableList.stream().filter(e->e.getCountry().contains(b)).mapToLong(d -> d.getPopulation()).sum();	
		System.out.println(b+"total population: "+total);

		System.out.println("Enter Country  name to find its city's count");
		String c = sc.next();
		
		long listcount = tableList.stream().filter(r->r.getCountry().equals(c)).count();
		System.out.println(c +" "+listcount);
		sc.close();
	}
}

class StreamList{
	
	public static List<Stream> strmTable(){
	
	Stream count1 = new Stream("USA","Kansas City",509157);
	Stream count2 = new Stream("India","Chennai",7090000);
	Stream count3 = new Stream("USA","Los Angeles",3970000);
	Stream count4 = new Stream("Nepal","Kathmandu",1000000);
	Stream count5 = new Stream("India","Kolkata",14900000);
	Stream count6 = new Stream("USA","Denver",706000);
		
		List<Stream> strmList = new ArrayList<Stream>();
		
		strmList.add(count1);
		strmList.add(count2);
		strmList.add(count3);
		strmList.add(count4);
		strmList.add(count5);
		strmList.add(count6);
		
		return strmList;
		
	}
}


class Stream {
	
	private String country;
	private String place;
	private long population;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Stream [country=" + country + ", place=" + place + ", population=" + population + "]";
	}
	
	public Stream(String country, String place, long population) {
		super();
		this.country = country;
		this.place = place;
		this.population = population;
	}
	
	public Stream() {
		super();
		
	}
}
