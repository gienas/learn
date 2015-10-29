import java.io.IOException;
import java.util.HashSet;
import java.util.Set;



public  class MyInterfaceImpl implements MyInterface{

	@Override
	public void go() {
		// TODO Auto-generated method stub
		Set<Number> lvSet = new HashSet<Number>();
		lvSet.add(new Integer(1));
	}
}
