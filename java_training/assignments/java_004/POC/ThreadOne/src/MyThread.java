
class MyThread implements Runnable {

	Thread thrd;
	boolean suspended;
	boolean stopped;
	
	// Construct a new thread.
	MyThread(String name) {
		thrd = new Thread(this, name);
		thrd.start(); // start the thread
	}
	// Begin execution of new thread.
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for(int count=0; count < 50; count++) {
				System.out.println("Executing thread " + thrd.getName());
				Thread.sleep(2000);
				//use synchronized block to check suspended and stopped
				synchronized(this) {
					while(suspended) {
						System.out.println(thrd.getName() + " suspended from running");
						wait();
					}
					if(stopped) {
						break;
					}
				}
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		}
		catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " terminating.");
	}
	// Stop the thread.
	synchronized void mystop() {
		stopped = true;
		// The following ensures that a suspended thread can be stopped.
		suspended = false;
		notify();
		System.out.println("Permanently stopping the execution of thread: " + thrd.getName());
	}
	
	// Suspend the thread.
	synchronized void mysuspend() {
		suspended = true;
		System.out.println("Pausing thread: " + thrd.getName());	
	}
	
	// Resume the thread.
	synchronized void myresume() {
		suspended = false;
		notify();
		System.out.println("Resuming thread: " + thrd.getName());
	}
}