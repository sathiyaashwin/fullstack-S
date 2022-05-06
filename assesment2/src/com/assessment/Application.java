package com.assessment;

import static java.util.stream.Collectors.toList;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {

	public static void main(String[] args) {
		
		List<STable> tableList =StreamList.getStreamTable();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter place to find its country");
		String a=sc.next();
		//Function<STable,String> mapc =e->e.getCountry();
		//Predicate<STable> place =r->r.getPlace().equals(a);
		List<String> tableName = tableList.stream().filter(r->r.getPlace().equals(a)).map(e->e.getCountry()).collect(toList());
		tableName.forEach(System.out::println);
		
		System.out.println("Enter country name to get population");
		String b = sc.next();
		
		Predicate<STable> pop = r->r.getCountry().equals(b);
		Function<STable,Long> map =e->e.getPopulation();
		List<Long> tablepop = tableList.stream().filter(pop).map(map).collect(toList());
		tablepop.forEach(System.out::println);

		System.out.println("Enter country to find its count");
		String c = sc.next();
		long list =tableList.stream().filter(e->e.getCountry().equals(c)).count();
		System.out.println(c +" "+list);
		sc.close();
	}
}
class STable {
	
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
	public STable(String country, String place, long population) {
		super();
		this.country = country;
		this.place = place;
		this.population = population;
	}
	public STable() {
		super();
		
	}
	
}
class StreamList {
	
	public static List<STable> getStreamTable(){
		
		STable country1 = new STable("USA","Kansas City",501927);
		STable country2 = new STable("India","Chennai",7090000);
		STable country3 = new STable("USA","Los Angles",3970000);
		STable country4 = new STable("Nepal","Kathmandu",1000000);
		STable country5 = new STable("India","Kolkata",14900000);
		STable country6 = new STable("USA","Kansas City",706000);
		
		ArrayList<STable> strmsList = new ArrayList<STable>();
		
		strmsList.add(country1);
		strmsList.add(country2);
		strmsList.add(country3);
		strmsList.add(country4);
		strmsList.add(country5);
		strmsList.add(country6);
		
		return strmsList;
	}

}



	