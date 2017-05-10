package cz.tieto.notes.dao;

public class MainFinnaly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			System.out.println("Start");
			if (1==1) {
				throw new IllegalArgumentException("IAE");
			}
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Finnaly executed");
		}
		
	}

}
