package attention;

import java.io.File;

public class OperatorEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//dla wartoœci do -128 do 127 == dzia³a 
		Integer i1 = 10;
		Integer i2 = 10;
		System.out.println(i1==i2);
		goInt(i1,i2);
		i1= 128;
		i2= 128;
		System.out.println(i1==i2);
		goInt(i1,i2);
		i1= 129;
		i2= 129;
		goInt(i1,i2);
		short s3 = 32000;
		short s4 = 10;
		Short s1 = 128;
		Short s2 = 128;
		goShort(s1, s2);

		System.out.println( new Integer(10) == new Integer(10));
		goInt(new Integer(10), new Integer(10));
	}

	public static void goInt( Integer i1, Integer i2)
	{
		System.out.println("i1=" + i1+ " i2=" + i2 + "   i1==i2 daje " + (i1==i2));
	}
	public static void goShort( Short i1, Short i2)
	{
		System.out.println("s1=" + i1+ " s2=" + i2 + "   i1==i2 daje " + (i1==i2));
	}
}
