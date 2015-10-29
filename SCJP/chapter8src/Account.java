public class Account implements Runnable {

	private int balance = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Account lvAccount = new Account();
	 	Thread t1 =  new Thread(new Account(),"t1");
		Thread t2 =  new Thread(new Account(),"t2");
		t1.start();
		t2.start();
		System.out.println("End main thread");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

			for (int i = 0; i < 5; i++) {
				if (balance > 0) {
					try {
						Thread.sleep("t1".equals(Thread.currentThread().getName()) ? 100: 150);
						balance -= 10;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println( "finish " +  Thread.currentThread().getName());
		}
	

}
