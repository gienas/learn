package literals;

public class MainOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	//!!!Wynik operacji char, byte, short, int to zawsze int	
	int i = 'A' + 'B';
	short s1 = 1;
	short s2 = 2;
	short lvShort = (short)(s1 + s2); 
	
	int z = s2;
	double d = 100;
	System.out.println((byte)128);
	byte b= 3;
	b+=4;
	
	int a = 0;
	if ( args != null)
		a=1;
	//System.out.println(a);
	
	
	Integer lvI;
	//lvI.getInteger("");
	
	int[] array = new int[12];
	
	//System.out.println(array);
	
	//System.out.println(s);
	int[][][] array3 = new int[3][][];
	array3[0] = new int[2][];
	array3[0][0] = new int[2];
	
	takeArray(new int[]{1,2,3});
	
	float lvF = 1;
	int [] intarray = new int[4];
	new Short((short)1);
	//new Integer(1).floatValue()

	Integer t1 = 100;
	Integer t2 = 100;
	
	System.out.println("t1==t2 =" + ( t1==t2));
	System.out.println("t1!=t2 =" + ( t1!=t2));
	int[][] tab ={{1,2,}, {1,2}}; 
	System.out.println(tab.length);
	Object o = tab;
	System.out.println( (int[])o);
	
	String s = "";
	s += "";
	}

	
	public static void takeArray( int[] array)
	{
		
	}
	
}
