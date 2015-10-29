public class Parallel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Parallel lvParallel = new Parallel();
		//System.out.println(Thread.currentThread().getId());
		Thread lvT1 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					lvParallel.go();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread lvT2 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					lvParallel.back();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		lvT1.start();
		lvT2.start();
	}
	 synchronized
	 public void go() throws InterruptedException {
		 {
			System.out.println("processing go ID = " + Thread.currentThread().getId());
			Thread.sleep(1000 * 5);
			
		}
		
	}
	 synchronized
	 public void back() throws InterruptedException {
		System.out.println("process back ID = " + Thread.currentThread().getId());
		Thread.sleep(1000 * 5);
	}

}
