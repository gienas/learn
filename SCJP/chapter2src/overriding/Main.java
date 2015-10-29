package overriding;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SuperAbstractClass lvObj = new SubClass();
		lvObj.go();
	}

	public static Integer go(int i)
	{
		return null;
	}
	
	
}
