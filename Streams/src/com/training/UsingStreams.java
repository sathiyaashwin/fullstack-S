package com.training;
import java.util.*;
import static java.util.stream.Collectors.*;
import com.training.model.Book.Book;

public class UsingStreams {

	public static void useDistinct(List<Book> bookList) {
			bookList.stream().distinct().forEach(System.out::println);

	}
	
	public static void collectToSet(List<Book> bookList) {
		
		Set<Book> bookset = bookList.stream().filter(e -> e.getPrice()>500)
							.collect(toSet());
		bookset.forEach(System.out::println);
	}
	public static void collectToMap(List<Book> bookList) {
		
		//Set <Book> bookSet= bookList.stream().collect(toSet());
		Map<String, Double> values = bookList.stream()
				.filter(e -> e.getPrice()>500).distinct()
				.collect(toMap(Book::getBookName,Book::getPrice));
		values.forEach((key,value)-> System.out.println(key+ "," +values));;
	}
	public static void findMaxPrice(List<Book> bookList) {
		
		Optional<Book> Optional =
				bookList.stream().max(Comparator.comparing(Book::getPrice));
		
		if (Optional.isPresent())
		{
			System.out.println("Maximum Price : " + Optional);
		}
	}
	public static void findMinPrice(List<Book> bookList) {
		
		Optional<Book> Optional =
				bookList.stream().min(Comparator.comparing(Book::getPrice));
		
		if (Optional.isPresent())
		{
			System.out.println("Minimum Price : " + Optional);
		}
	}
	
         public static void count(List<Book> bookList) {
		
		long count  =
				bookList.stream().filter(e -> e.getBookName().contains("v")).count();
		System.out.println("count = " +count);
		
	
	}
	public static void main(String[] args) {
		
		Book java = new Book(101,"java","suba",450);
		Book spring = new Book(102,"spring","mad",650);
		Book maven = new Book(103,"maven","Harish",550);
		Book html = new Book(104,"html","priya",1450);
		Book python = new Book(105,"python","sathya",850);
		Book htmlNew = new Book(104,"html","priya",1450);
		Book pythonNew = new Book(105,"python","sathya",850);
		
		List<Book> bookList = Arrays.asList(java,spring,maven,html,python,htmlNew,pythonNew);
		useDistinct(bookList);
		//collectToSet(bookList);
		//collectToMap(bookList);
		//findMaxPrice(bookList);
		//findMinPrice(bookList);
		count(bookList);
		}
	}