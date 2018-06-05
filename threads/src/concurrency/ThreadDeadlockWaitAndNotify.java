package concurrency;

public class ThreadDeadlockWaitAndNotify {
	static Boolean flagsrc = true;
	public static void main(String[] args) {
		final String resource1 = "one";

		// t1 tries to lock resource1 then resource2
		Thread t1 = new Thread() {
			public void run() {

				synchronized (resource1) {

					try {
						System.out.println("Thread 1: Before Wait");
						Thread.sleep(10000);
						resource1.wait();//********
				
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}

				}
			}

		};

		Thread t2 = new Thread() {
			public void run() {

				synchronized (resource1) {

				
					System.out.println("Thread 2: locked resource 1");
					System.out.println("Before notifying");
					resource1.notifyAll();
				}
			}

		};

		t1.start();
		t2.start();

	}

}
