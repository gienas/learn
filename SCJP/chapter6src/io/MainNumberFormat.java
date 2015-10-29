package io;

import java.text.NumberFormat;

public class MainNumberFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		NumberFormat lvFormat = NumberFormat.getInstance();
		
		System.out.println(lvFormat.format(1.12354) + " " + NumberFormat.getCurrencyInstance().format(1.1263));
	
	}
	

}
