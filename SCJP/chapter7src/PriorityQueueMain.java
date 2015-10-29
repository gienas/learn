import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class PriorityQueueMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> lQue = new PriorityQueue<String>();
		lQue.add("4");
		lQue.offer("3");
		lQue.offer("2");
		lQue.offer("2");
		for ( String lvString: lQue )
		{
			System.out.println(lvString);
		}	
		
		System.out.println();
		
		List<ArrayList<String>> lvList = new ArrayList<ArrayList<String>>();
		
	}

}
