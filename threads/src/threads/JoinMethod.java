package threads;

public class JoinMethod extends Thread {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}

	public static void main(String args[]) {
		JoinMethod t1 = new JoinMethod();
		t1.setName("Thread1");
		JoinMethod t2 = new JoinMethod();
		t2.setName("Thread2");
		JoinMethod t3 = new JoinMethod();
		t3.setName("Thread3");
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e);
		}

		t2.start();
		t3.start();
	}
}
