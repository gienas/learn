
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 1;
		int icopy = 0;
		short s = 2;
		byte b = 3;
		float f = 1.5F;
		double d  = 2.5;
		String st = "123";
		
		icopy = ++i;
		byte b1 = 1;
		byte b2 = 1;
		
		Character ch1 = 'v';
		Character ch2 = 'v';
		
		if ( ch1==ch2) System.out.println(ch1==ch2);
		System.out.println( 2+3*4);
		Long x = 10L;
		
		if ( 10.0f == x)
		{
			System.out.println(true);
		}	
	}

	
	public static boolean go()
	{
		System.out.println("go");
		return true;
	}
	
	public static boolean go1()
	{
		System.out.println("go1");
		return false;
	}
}
