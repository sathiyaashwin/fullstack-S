package com.training;

import java.util.logging.Level;
import java.util.logging.Logger;

	public class Application {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Logger log = Logger.getLogger("com.example.Application");
			log.info("info message");
			System.out.println("info mess");
			
			log.setLevel(Level.ALL);
			log.warning("Warning MESSAGE *******");
			log.severe("Severe Message %%%%%%%%");
			log.fine("I Am Fine Message");

		}

	}


