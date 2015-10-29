public class Starter implements Runnable {
	void go(long id) {
		System.out.println(id);
	}

	public static void main(String[] args) {
		System.out.print(Thread.currentThread().getId() + " ");
		// insert code here

	}

	public void run() {
		go(Thread.currentThread().getId());
	}
}

//I. new Starter().run();
//II. new Starter().start();
//III. new Thread(new Starter());
//IV. new Thread(new Starter()).run();
//V. new Thread(new Starter()).start();