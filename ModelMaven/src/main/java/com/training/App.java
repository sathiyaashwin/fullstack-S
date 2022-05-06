package com.training;

/**
 * Hello world!
 *
 */
public class App
{
    

	public static void main( String[] args )
    {
    	TextBook ob=new TextBook("Harry Potter", 678);
		System.out.println(ob.bookFilter(456));
		System.out.println(ob);
		
    }
	@Override
    public String toString() {
		return "App []";
	}
}