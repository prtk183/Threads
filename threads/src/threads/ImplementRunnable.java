package threads;

public class ImplementRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		ImplementRunnable m1 = new ImplementRunnable();
		Thread t1 = new Thread(m1);
		t1.start();
	}
}
