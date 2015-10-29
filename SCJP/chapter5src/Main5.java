
public class Main5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int b;
		b=2;
		
		switch ( b)
		{
		case 1: System.out.println("1");
		case 2: System.out.println("2");
		case 3: System.out.println("3");
		}
		
		switch (b){
		case 0: {
			//todo
		}
		}
		
		Character lvChar = 'a';
		
		switch (lvChar)
		{
			default:{ System.out.println("default"); break;}
			case 'a':{ System.out.println("a"); break;}
		}
	
		do
		{
			System.out.println("do loop");
		} while(false);
		
		
		for ( long i=0, j=1; i>1; i++)
		{
			System.out.println("for");
		}	
		
		Long[] longTab = { 1L,2L,3L,4L,};
		long l;
		for( long ll:longTab)
		{}	
		
	}

}
