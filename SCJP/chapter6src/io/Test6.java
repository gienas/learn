package io;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Pattern lvPat = Pattern.compile("^.*(\\d)$");
		Matcher lvMatch = lvPat.matcher("asda1");
		System.out.println( lvMatch.find());
		
		Integer lvInt = 1;
		new File("files", "file.txt").createNewFile();
	}

}
