package com.training;

import java.util.Collections;
import java.util.List;

import com.training.Services.BookService;
import com.training.ifaces.CrudRespository;
import com.training.model.Book.Book;
import com.training.utils.BookNameComparator;

public class App {
	public static void print( List<Book>book) { //Collection<Book> can also  can be used because its a super class
		for(Book eachvalue: book) {
			System.out.println(eachvalue);
		}
	}

	public static void main(String[] args) {
		
	Book java = new Book(101,"java","suba",450);
	Book spring = new Book(103,"spring","mad",650);
	Book maven = new Book(106,"maven","Harish",550);
	Book html = new Book(104,"html","priya",1450);
	Book python = new Book(105,"python","sathya",850);
	
	CrudRespository service = new BookService();
	
    System.out.println("is added :" +service.add(java));
	service.add(java);
	service.add(spring);
	service.add(maven);
	service.add(html);
	service.add(python);
	List<Book> bookList = service.findAll();
	
	Collections.sort(bookList);
	System.out.println(bookList);
	System.out.println("****************************************");
	BookNameComparator book = new BookNameComparator();
	Collections.sort(bookList,book);
	print(bookList);
	
	


	System.out.println("Greater than value ");
	List<Book> bookLists=((BookService)service).getBookGrtThan(1000);
	bookLists.forEach(System.out::println);
	
	//System.out.println(((BookService)service).getBookGrtThan(20));
	
}
}



