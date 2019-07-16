// Create multiple threads.
class MyThread implements Runnable {
	Thread thrd;
	// Construct a new thread.
	MyThread(String name) {
		thrd = new Thread(this, name);
		thrd.start(); // start the thread
	}
	// Begin execution of new thread.
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for(int count=0; count < 20; count++) {
				Thread.sleep(600);
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		}
		catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " terminating.");
	}
}	