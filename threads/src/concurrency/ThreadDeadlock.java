package concurrency;

public class ThreadDeadlock {
	static Boolean flagsrc1 = true;
	static Boolean flagsrc2 = true;

	public static void main(String[] args) {
		final String resource1 = "one";
		final String resource2 = "two";

		// t1 tries to lock resource1 then resource2
		Thread t1 = new Thread() {
			public void run() {

				synchronized (resource1) {

					System.out.println("Thread 1: locked resource 1");

					try {
						//Thread.sleep(10000);
						resource1.wait();

					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}

					synchronized (resource2) {

						System.out.println("Thread 1: locked resource 2");
						try {
							 //Thread.sleep(1000);
							resource2.wait();
						} catch (InterruptedException e) {
					
							e.printStackTrace();
						}
					}

				}

			}

		};

		// t2 tries to lock resource2 then resource1
		Thread t2 = new Thread() {
			public void run() {

					synchronized (resource2) {
						flagsrc2 = false;
						System.out.println("Thread 2: locked resource 2");
						try {
							 //Thread.sleep(1000);
							 resource2.wait();
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
											
						synchronized (resource1) {
							System.out.println("Thread 2: locked resource 1");
							try {
								//Thread.sleep(1000);
								 resource1.wait();
							} catch (InterruptedException e) {
							
								e.printStackTrace();
							}
							
							
						}
					}
		    	}
       		
		};

		t1.start();
		t2.start();

		
	}

}
