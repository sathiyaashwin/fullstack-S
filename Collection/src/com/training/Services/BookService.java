package com.training.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.training.ifaces.CrudRespository;
import com.training.model.Book.Book;

public class BookService implements CrudRespository {
	
	private ArrayList<Book> bookList;
	
	
	@Override
	public boolean add(Book book) {
		//boolean result=bookList.add(book);
		//return result;
		return bookList.add(book);
		
	}

	public BookService() {
		super();
		this.bookList=new ArrayList<>();
	}

	@Override
	public Book findById(int id) {
		Book found = null;
		for(Book eachBook : bookList) {
			
			if(eachBook.getBookNumber()==id) {
				found = eachBook;
			}
		}
		return found;
	}

	@Override
	public boolean remove(Book book) {
		return bookList.remove(book);
	}

	@Override
	public List<Book> findAll() {
		return this.bookList;
	}

	@Override
	public Book update(Book oldbook,Book newBook) {
		if(this.bookList.contains(oldbook)) {
			//System.out.println("Inside Else block *********");
			
			int idxPos = this.bookList.indexOf(oldbook);
			this.bookList.set(idxPos, newBook);
			
		}
		return newBook;
	}
	public List<Book> getBookGrtThan(double price){
		// write using predicate and forEach
		
		Predicate<Double> grtThan=(value)->value>price;
		List<Book>list=new ArrayList<>();
		
		
	this.bookList.forEach(book ->
	{
		
		double bookPrice=book.getPrice();
		if(grtThan.test(bookPrice)) {
			list.add(book);
		}
	});
	return list;

}
}