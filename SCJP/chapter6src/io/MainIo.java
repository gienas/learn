package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MainIo {

	
	public static void  main(String[] tab ) throws Exception
	{
		//PrintWriter lvWriter  = new PrintWriter( new File(""));
		//BufferedReader lvReader = new BufferedReader( new FileReader(new File("")));
		//FileWriter lolo =  new FileWriter();
		//PrintWriter
		//lolo.write("zibi rozalsky");
		//lolo.close();
		BufferedWriter lvWriter = new BufferedWriter(new FileWriter(new File("lolo")));
		PrintWriter  lvWriter1= new PrintWriter( "lolo");
		
		lvWriter.write("zibi");
		lvWriter1.println("zibi");
		
		lvWriter.close();
		lvWriter1.close();
		
//		FileReader lvReader = null;
//		char[] lvTab = new char[12];
//		lvReader.read(lvTab);
		
		System.out.println(new File("lolo").mkdir());
		
	}
}
