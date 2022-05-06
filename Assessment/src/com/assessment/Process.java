package com.assessment;

public class Process {
	

	public void permute(String str,int start,int end )
	{
		if(start == end)
		{
			System.out.println(str);
		}
		else
		{
			for (int i=0;i<=end;i++)
			{
				str = swap(str,start,i);
				permute(str,start+1,end);
				str=swap(str,start,i);
			}
		}
	}
	
	
	private String swap(String str, int i, int j) {
		
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=temp;
		return String.valueOf(charArray);
		
	}

}

