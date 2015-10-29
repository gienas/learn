import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;


public class MainCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> lvSet = new HashMap<String, String>(){{put("lolo","lolo");put("zibi", "zibi");}};
		System.out.println( new MainCollection().hashCode());
		System.out.println( new MainCollection().hashCode());
		System.out.println( new MainCollection().hashCode());
	}

}
