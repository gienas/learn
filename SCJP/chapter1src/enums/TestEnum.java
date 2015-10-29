package enums;

enum Animals {

	DOG("woof"), CAT("meow"), FISH("burble");

	String sound;

	Animals(String s) {
		sound = s;
	}
	
	public String getSound() {
		return sound;
	}
	
	
}

class TestEnum {
	static Animals a;

	public static void main(String[] args) {
		//System.out.println(a.DOG.ordinal());
		//System.out.println(a.DOG.sound + " " + a.FISH.sound);
		
		System.out.println(getValue("burble"));
	}
	
	public static Animals getValue(String text) 
	{
		for ( Animals a: Animals.values())
		{
			if (text.equals(a.getSound()))
			{
				return a;
			}	
		}	
		return null;
	}
	
}
