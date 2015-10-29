import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;


public class MainScaner {

	public static void main( String... strings )
	{
		String lvString = "a;2;s;4";
		
		Scanner lvScanner = new Scanner(lvString);
		lvScanner.useDelimiter(";");
		
		while ( lvScanner.hasNext())
		{
			if ( lvScanner.hasNextInt())
			{	
			 System.out.println(lvScanner.nextInt());
			}
			else
			lvScanner.next();	
		}	
		
		List<Number> lvIN = null;
		List<Number> lvOut = null;
		lvOut = process(lvIN);
		PriorityQueue lvq = null;
	}
	
	
	public static <E extends Number> List<E> process( List<E> nums)
	{
		return null;
	}
}
