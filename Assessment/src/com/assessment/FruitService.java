package com.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FruitService implements Fruits {
	
	
	HashSet<String> fruit=new HashSet<>();

	@Override
	public String add(String[] obj) {
		
		for(int i=0;i<obj.length;i++) {
			String value=obj[i];
			fruit.add(value);
			}
		
		
		ArrayList<String> list= new ArrayList<String>(fruit);
		Collections.sort(list);
		
	
			System.out.println(list);
	
			
		return null;
	}

}