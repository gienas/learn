
public class MainInnterupd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Przed przerwaniem");
		Thread.currentThread().interrupt();
		while (true)
		{	
		System.out.println("Po przerwaniu");
		}
	}

}
