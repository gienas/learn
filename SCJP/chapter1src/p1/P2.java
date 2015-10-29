package p1;

import java.io.IOException;




 public class P2  extends P1{

	public void go() throws IOException
	{
		//System.out.println(var);
		System.out.println(new P1().varprot);
		System.out.println(new P1().varprot);
		System.out.println(new P1().vardef);
		System.out.println(varprot);
	}

	native public void goahed();
}
