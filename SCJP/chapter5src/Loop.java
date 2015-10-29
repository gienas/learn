public class Loop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// for (int i=0;i<10;i++)
		// {
		// for ( int j=0; j<10;j++)
		// {
		// System.out.println("j=" + j);
		// if ( j==4) break;
		// }
		// }

		boolean isTrue = true;
		outer: for (int i = 0; i < 5; i++) {
			while (isTrue) {
				System.out.println("Hello");
				break;
			} // end of inner while loop
			System.out.println("Outer loop."); // Won't print
		} // end of outer for loop
		System.out.println("Good-Bye");

		myfor: for (int z = 1; z < 10; z++) {

		}
	}

}
