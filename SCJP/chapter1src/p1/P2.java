package p1;

import java.io.IOException;




 public class P2  extends P1{

	public void go() throws IOException
	{
		//System.out.println(var);
		System.out.println(new P1().var);
	}

	native public void goahed();
}
