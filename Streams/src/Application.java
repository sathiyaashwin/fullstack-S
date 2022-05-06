

import java.util.List;

import com.training.Services.BookService;
import com.training.ifaces.CrudRespository;
import com.training.model.Book.Book;

public class Application {
	
	public static void print(List<Book> booArraykList) {
		for(Book eachBook:booArraykList) {
			System.out.println(eachBook);
		}
	}

	public static void main(String[] args) {
		
		Book java = new Book(101,"java","suba",450);
		Book spring = new Book(102,"spring","mad",650);
		Book maven = new Book(103,"maven","Harish",550);
		Book html = new Book(104,"html","priya",1450);
		Book python = new Book(105,"python","sathya",850);
		
		CrudRespository service = new BookService();
		
		service.add(java);
		service.add(spring);
		service.add(maven);
		service.add(html);
		service.add(python);
		
		List<Book> bookList = service.findAll();
		
		
		for(Book eachBook:bookList) {
			System.out.println(eachBook);
		}
		System.out.println("---------------------------------------------");
		System.out.println("Find Book by Id");
		System.out.println(service.findById(103));
		
		System.out.println("-----------------------");
		System.out.println("The object i need to be delete-"+service.remove(spring));
		print(service.findAll());
		
		Book react = new Book(106,"ReactJs","Rahul",6800);
		service.add(react);
		System.out.println("-----------------Adding new Book----------------------------");
		print(service.findAll());
		
		Book reactNew = new Book(106,"ReactJs","Gowhsick",7000);
		
		service.update(react,reactNew);
		
		System.out.println("-------------------AFTER UPDATE-------------------");
		print(service.findAll());
		
		List<String> nameList = ((BookService)service).getBookNames();
		nameList.forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		System.out.println("Greater Than");
		List<Book> bookList1 = ((BookService) service).getBookGrtThan(800);
		bookList1.forEach(System.out::println);
		
		System.out.println("using Streams");
		((BookService)service)
							.findBookGrtThan(100)
							.forEach(System.out::println);
		
		
	}

}
