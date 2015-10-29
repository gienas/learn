package exception;

import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new P2().go();
		P1 o = new P2();
		System.out.println("".substring(0,-1) );
		//go();
	
	}

	public void go1() 
	{
		
	}
	
	public static void go() throws RuntimeException
	{
		new String("");
		
		String[] lvTab;
		

		
		try
		{
			System.out.println(1/0);
		}
		catch ( Error e)
		{
			System.out.println("fsdfsdfsdf");
		}
		
	}
	
	
	
}
