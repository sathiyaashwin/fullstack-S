package com.training;

import java.io.File;

import com.training.Services.BookService;
import com.training.model.Book.Book;

public class Application {

	public static void main(String[] args) {
		Book java = new Book(101," JAVA head","Ani",19000);
		BookService service = new BookService();
		boolean result = service.writeToFile(new File("Books.txt"),java);
		
		if(result) {
			System.out.println("one record added to file");
		}
		
		service.readFromFile(new File("Books.txt")).forEach(System.out::println);

	}

}