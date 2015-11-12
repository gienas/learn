import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class MainHashCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Foo> lvLolo = new HashSet<Foo>();

		lvLolo.add(new Foo(100));
		lvLolo.add(new Foo(1));
		System.out.println(lvLolo.size());
		System.out.println(lvLolo);
		System.out.println(new Foo().hashCode() == new Foo().hashCode());
		System.out.println(new Foo().equals(new Foo()));
		

		PriorityQueue<Integer> lvQue = new PriorityQueue<Integer>();
		//Collections.sort(lvList);
		for (Foo lv: lvLolo)
		{
			System.out.println( Integer.toHexString(lv.hashCode()));
		}	
		System.out.println(lvLolo);
		
		List<Foo> list = new ArrayList<>(lvLolo);
		System.out.println("list" + list);
		Collections.sort(list);
		System.out.println("list" + list);
	}
	
}

class Foo implements Comparable<Foo> {
	
	TreeSet<Integer> set = new TreeSet<>();
	
	public Foo() {
		// TODO Auto-generated constructor stub
	}

	public Foo(int x) {
		// TODO Auto-generated constructor stub
		i=x;
	}
	
	
	Integer i = 0;
	
	@Override
	public boolean equals(Object obj) {		
		return true;
		//return super.equals(obj);
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode() ;
	}


	@Override
	public int compareTo(Foo o) {
		// TODO Auto-generated method stub
		return this.getI().compareTo(o.getI());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+i;
	}
	
	public Integer getI() {
		return i;
	}
}