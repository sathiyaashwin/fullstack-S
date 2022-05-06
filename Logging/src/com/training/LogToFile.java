package com.training;

import java.util.logging.*;

public class LogToFile {

	public static void main(String[] args) {
	 
		
		Logger log = Logger.getLogger(LogToFile.class.getName());
		
		FileHandler handler  ;
		
		//log.addHandler(handler);
		try {
			handler =new  FileHandler("logs.log");
			log.addHandler(handler);
			
			
			log.info("try block called");
			throw new RuntimeException("k is a programmer");
			
		}catch (SecurityException e) {
			log.warning(e.getMessage());
		
		}
		catch(Exception e) {
			log.warning(e.getMessage());
		}
	}

}
