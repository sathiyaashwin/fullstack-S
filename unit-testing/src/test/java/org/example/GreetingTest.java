package org.example;




import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GreetingTest {
	
	@Test
	@DisplayName(value = "Test the Get Message return a string of Length 8 characters")
	void testMaxLengthOffGetMessage() {
		
		Greeting grtObj = new Greeting();
		
		int actual = grtObj.getMessage().length();
	    int expected =5;
	    
	    assertEquals(expected, actual);
		
	}
	
	@Test
	@DisplayName("Test Birthday Wish method return Happy Birthday with user name suffixed")
	void testBirthDayWish() {
		Greeting grtObj = new Greeting();
		
		String arg = "ramesh";
		String actual = grtObj.birthdayWish(arg);
		String expected = "Happy Birthday" + arg;
		
		assertEquals(expected,actual);
		}
	

}
