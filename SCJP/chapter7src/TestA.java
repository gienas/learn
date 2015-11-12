import java.io.Serializable;

public class TestA <T extends Serializable> {

	T aaa;
	
	public void setAaa (T a)
	{
		aaa = a;
	}
	
}
