import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class MainGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exception[] lvTab = new IOException[10];
		//lvTab[0] = new IllegalArgumentException();
		
		List<Exception> lvList = new ArrayList<Exception>();
		lvList.add( new RuntimeException());
		lvList.add(  new  IOException() );
		go(lvList);
		go2(new Integer(1));
	}
	
	public static void go ( List< ? super IOException> lvList)
	{
		//Mo¿na dodaæ tylko null
		lvList.add(  new  IOException() );
		//lvList.add()
	}

	public static <T> T go2(T pm)
	{
		return pm;
	}
	
	
	
}

class zibi<T>
{
	public <D> zibi( D pm)
	{
		int i = 0;

	}
	
	public void go (T pm)
	{
		
	}
}
