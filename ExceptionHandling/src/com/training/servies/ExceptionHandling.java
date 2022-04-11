package com.training.servies;

public class ExceptionHandling {

	public void usingArrayIndexException(String[] args) {
		
		try {
			System.out.println(args[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.err.println("Method requires three "
					+ "values to be passed [a,b,c]");
			//e.printStackTrace();
		}
	}
	public void usingNumberFormatException(String value) {
		
		int age=0;
		try {
			age = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("Foutry five is not"
					+ " accepted 45 is acceptable");
		}
		System.out.println(age);
	}
	public String usingStandFinallyBlock() throws Exception
	{
		int denominator=4;
		
		try
		{
			System.out.println(4/denominator);
		}catch (ArithmeticException e)
		{
			System.out.println("Denominator should not be zero");
			//return "welcome";
			throw new Exception();
		}
		finally {
			System.out.println("Inside Finally++");
		}
		System.out.println("thanks ,bye,bye");
		return "thanks";
	}
	
	
}