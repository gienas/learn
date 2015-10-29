package io;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;


public class MainSerialization {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		// TODO Auto-generated method stub
		
		PojoAdress lvAdress =  new PojoAdress("adress");
		
		PojoPerson lvPerson = new PojoPerson(lvAdress , 123, "lolita", new BigDecimal("1922.00"));
		PojoPerson lvPerson1 = new PojoPerson(lvAdress , 123, "lolita", new BigDecimal("1922.00"));
 		ObjectOutputStream lvoutStream = new ObjectOutputStream (new FileOutputStream("files/ser.dat"));
		lvoutStream.writeObject(lvPerson);
		lvoutStream.writeObject(lvPerson1);
		lvoutStream.close();
		
		ObjectInputStream lvInput = new ObjectInputStream(new FileInputStream("files/ser.dat"));
		PojoPerson lvPerson00 =  (PojoPerson)lvInput.readObject();
		PojoPerson lvPerson10 =  (PojoPerson)lvInput.readObject();
		System.out.println();
	}

}
