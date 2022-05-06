package com.training.Services;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.training.model.Book.Book;

public class BookService {

public Object readFromStream(File file) {
	Object obj = null;

		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
			
			obj =inputStream.readObject();
			 
		} catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();		}
		return  obj;
		}
	
	
public boolean writeToStream(File file ,Book book) {
	boolean result= false;

		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
			
			outputStream.writeObject(book);
			 result = true;
		} catch (IOException e) {
           e.printStackTrace();		}
		return result;
		}
	
	
	
	
	
	
public boolean writerToFile(File file, Book book) {

boolean result = false;


try (PrintWriter writer = 
new PrintWriter(
new FileWriter( file,true));)
{

writer.println(book);
result = true;

} catch (IOException e) {

e.printStackTrace();
}
return result;

}


public List<Book> readFromFile(File file){

List<Book> booklist = new ArrayList<Book>();

String line = null;

try (BufferedReader reader =
new BufferedReader(new FileReader(file))){





while( (line = reader.readLine())!=null) {

String[] values = line.split(",");

Book book =new Book(Integer.parseInt(values[0]),
values[1],values[2],
Double.parseDouble(values[3]));
booklist.add(book);

}

} catch (Exception e) {
e.printStackTrace();
}



return booklist;

}



}