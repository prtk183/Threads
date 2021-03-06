package threads;

class Tab {

	void printTable(int n) {
		synchronized (this)
		{// synchronized block***************
			for (int i = 1; i <= 5; i++) 
			{
				System.out.println(n * i);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}// end of the method
	}
}

public class SynchronizationBlockDemo {

	public static void main(String args[]) {
		final Table obj = new Table();// only one object

		Thread t1 = new Thread() {
			public void run() {
				obj.printTable(5);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				obj.printTable(100);
			}
		};
		
		t1.setName("First");
		t2.setName("Second");
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}

}
