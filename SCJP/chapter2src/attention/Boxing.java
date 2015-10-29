package attention;

public class Boxing {
	public static void main(String[] args) {
	
		int i = 1;
		
		Long l = 10l;
		long l2 = 10l;
		Short s = 2;
		go(s);
		System.gc();
		short sh = 1;
		
		int[] lvTabInt = {sh};
		short[] lvTabShort = new short[2];
		float aa = 2.3F;
	}
	
	public static void go(Number i)
	{
		System.out.println("public static void go(Number i)");
	}

	public static void go(Integer i)
	{
		System.out.println("public static void go(Integer i)");
	}
	public static void go(Long l)
	{
		System.out.println("public static void go(long i)");
	}
}
