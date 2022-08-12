package com.training;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fruits {
	
	public static void main(String[] args) {
		File myFile = new File("Fruit.txt");
	    File myFile1 = new File("File.txt");
	    
	  try {
	      
	      FileWriter myWriter = new FileWriter("Fruit.txt");
	      myWriter.write("Apple is red in color\nOrange is round in shape\nBanana is good for health\nGrapes will grow as bunch\nMango is a seasonal fruit");
	      myWriter.close();
	      
	      FileWriter myWriter1 = new FileWriter("File.txt");
	      myWriter1.write("Description");
	      myWriter1.close();
	      
	      System.out.println("Files are created successfully");
	      
	      
	      
	      PrintWriter writer = new PrintWriter("File.txt");
	          
	        
	        BufferedReader bufferbr = new BufferedReader(new FileReader("Fruit.txt"));
	          
	        String line = bufferbr.readLine();
	          
	        while (line != null)
	        {
	        	writer.println(line);
	            line = bufferbr.readLine();
	        }
	        writer.flush();
	          

	        bufferbr.close();
	        writer.close();
	        
	           if (myFile.delete()) {
	            System.out.println("Files are deleted successfully");
	        }
	        else {
	            System.out.println("Failed to delete the file");
	        }
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }

	  }

	}


