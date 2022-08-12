package org.example;



import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.model.Book;
import org.example.service.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookServiceTest {
	
	@Test
	@DisplayName(value = "Get should not return null value")
	void testGetBookMethod() {
		
		BookService service =  new BookService();
		

		Object actual = service.getBooklist();
		
	    assertNotNull(actual);
	}

	@Test
	@DisplayName(value = "add method should return 1 for success and 0 for failure to insert")
	void testvalue() {
	BookService obj = new BookService();
	Book book=new Book(13, "The Witcher",500);
	Object actual = obj.addBook(book);
    int expected =1;
    
    assertEquals(expected, actual);
	}
	@Test
	@DisplayName(value = "if the element is not found in the collection remove book method should throw RunTimeException 'Invalid Element'")
	void testRemoveBook() {
		Book book=new Book(3, "Laip of Baki", 100.0);
		BookService service=new BookService();
		//boolean result=service.removeBook(book);
		
		Throwable e=assertThrows(RuntimeException.class,
				()-> service.removeBook(book));
		assertEquals("Invalid Element",e.getMessage());
		
	}
}
