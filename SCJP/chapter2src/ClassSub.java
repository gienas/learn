
public class ClassSub extends ClassSuper implements ClassInterface {

	@Override
	public void go() {
		// TODO Auto-generated method stub
		System.out.println("go from subclass");
	}
	
	//from interface
	@Override
	public void clean() {
		System.out.println("Clean from subclass");
		super.clean();
	}
}
