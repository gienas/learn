package io;

import java.io.Console;

public class MainConsole {

	public static void  main(String[] tab ) throws Exception
	{
		Console lvConsole = System.console();
		System.out.print("Podaj użytkownika: ");
		String lvUser =  lvConsole.readLine();
		lvConsole.format("%s", lvUser);
		//System.out.println("Użytkownik:" + lvUser);
	}	
}
