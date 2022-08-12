package org.example.service;
import java.util.*;

import org.example.model.Book;

public class BookService{

private List<Book> booklist;


public BookService() {
	super();
	this.booklist = new ArrayList<>();
}

public List<Book> getBooklist(){
	
	return this.booklist;
		
}

public  int addBook (Book book) {
  return this.booklist.add(book)?1:0;
  
}
public boolean removeBook (Book book) {
	
	boolean result =false;
	if (this.booklist.contains(book))
	{
		this.booklist.remove(book);
		result = true;
	}
	else {
		throw new RuntimeException("not there");
	}
	return result;
}
}
