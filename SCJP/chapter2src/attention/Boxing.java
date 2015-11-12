package attention;

public class Boxing {
	public static void main(String[] args) {
	
		int i = 1;
		Short s = 1;
		long l2 = 10l;
		Long l = 10l;
		System.out.println("call go(Short s = 1;)");
		go(s);
		System.out.println("call long l2 = 10l;)");
		go(l2);
		System.out.println("Long l = 10l;");
		go(l);
		System.gc();
		short sh = 1;
		
		int[] lvTabInt = {sh};
		short[] lvTabShort = new short[2];
		float aa = 2.3F;
		
		
		Integer a = new Integer(1);
		System.out.println(a);
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
	
	public void change(Integer i)
	{
		i.parseInt("2");
	}
}
