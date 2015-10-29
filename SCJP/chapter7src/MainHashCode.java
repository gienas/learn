import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MainHashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Foo> lvLolo = new HashSet<Foo>();

		lvLolo.add(new Foo());
		lvLolo.add(new Foo());
		System.out.println(lvLolo.size());
		System.out.println(lvLolo);
		System.out.println(new Foo().hashCode() == new Foo().hashCode());
		
		List<Foo> lvList = new ArrayList<Foo>();
		PriorityQueue<Integer> lvQue = new PriorityQueue<Integer>();
		//Collections.sort(lvList);
	}
}

class Foo {

	int i = 0;
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}