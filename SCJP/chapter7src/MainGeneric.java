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
		// lvTab[0] = new IllegalArgumentException();

		List<Exception> lvList = new ArrayList<Exception>();
		lvList.add(new RuntimeException());
		lvList.add(new NumberFormatException());
		go(lvList);
		go2(new Integer(1));
	}

	public static void go(List<? super IOException> lvList) {
		// Mo¿na dodaæ tylko null
		lvList.add(new IOException());
		// lvList.add()

		Number n = new Integer(1);

		ArrayList<? super Integer> objlist = new ArrayList<>();
		objlist.add(new Integer(1));

		// list
//		ArrayList<? extends Number> list = new ArrayList<>();
//		for (Number n : list) {
//			System.out.println(n);
//		}

		System.out.println(lvList);
		
		List<? extends Number> foo11 = new ArrayList<Number>();  // Number "extends" Number (in this context)
		List<? extends Number> foo12 = new ArrayList<Integer>(); // Integer extends Number
		List<? extends Number> foo13 = new ArrayList<Double>();  // Double extends Number
		//foo11.add(n);//wrong
		
		List<? super Integer> foo2 = new ArrayList<Number>();   // Number is a superclass of Integer
		List<? super Integer> foo1 = new ArrayList<Integer>();  // Integer is a "superclass" of Integer (in this context)
		List<? super Integer> foo3 = new ArrayList<Object>();   // Object is a superclass of Integer
		
		foo1.add(new Integer(1));
		foo2.add(new Integer(1));
		foo3.add(new Integer(1));
	
	}

	public static <T> T go2(T pm) {
		return pm;
	}

}

class zibi<T> {
	public <D> zibi(D pm) {
		int i = 0;

	}

	public void go(T pm) {

	}
	
	

}
