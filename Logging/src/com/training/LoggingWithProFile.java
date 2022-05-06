package com.training;

public class LoggingWithProFile {
	

		public static void main(String[] args) {
			
			
		String file=LoggingWithProFile.class.getClassLoader()
			                  .getResource("logging.properties")
			                  .getFile();
			  System.setProperty("java.util.logging.config.file", file);
			  Book.log.info("logging Properties Done Right");
			  Book java =new Book();
			  
			 Book.log.info(java.toString());
			}
	}



