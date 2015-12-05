package creation.prototype;

public abstract class Prototype implements Cloneable {
	
	int a = 1;
	
	public Prototype clone(){
		Prototype c = null;
		try {
			c = (Prototype)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	
	public static void main( String... strings )
	{
		Prototype p1 = new ConcretePrototype1();
		Prototype p2 = p1.clone();
		p2.setA(2);
		
		System.out.println(p1.getA() + " " + p2.getA() + " " + ( p1 == p2));
	}
}



class ConcretePrototype1 extends Prototype {
	@Override
	public Prototype clone() {
		return super.clone();
	}
}

class ConcretePrototype2 extends Prototype {
	@Override
	public Prototype clone() {
		return super.clone();
	}
}
