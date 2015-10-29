package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainSerializationTrick {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ObjectOutputStream lvoutStream = new ObjectOutputStream (new FileOutputStream("files/ser.dat"));
		PojoDog lvSer = new PojoDog("zelek");
		lvSer.name = "rokfor";
		lvSer.age = 26;
		System.out.println( "Przed " + lvSer.name + " " + lvSer.age);
		lvoutStream.writeObject(lvSer);
		lvoutStream.close();
		
		ObjectInputStream lvInput = new ObjectInputStream(new FileInputStream("files/ser.dat"));
		PojoDog lvDeSer = (PojoDog)lvInput.readObject();
		System.out.println( "Po " + lvDeSer.name + " " + lvDeSer.age);
		lvInput.close();
	}

}
