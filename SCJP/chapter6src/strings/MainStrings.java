package strings;

public class MainStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Ala makota";
		String s2 = s1;
		System.out.println("s1==s2 " + (s1==s2));
		s1  = s1.concat(" i psa");
		System.out.println("s1==s2 " + (s1==s2));
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		int [] tab = new  int[2];
		System.out.println(tab.length);
		
		System.out.println("-------------------------------------");
		String x = "0123456789";
		System.out.println(x.substring(0, 1));
		
		
		//StringBuffer
	}

}
