package threads;

public class ThreadPriority extends Thread {

	public void run() {
		System.out.println("running thread name is:" + Thread.currentThread().getName());
		System.out.println("running thread priority is:" + Thread.currentThread().getPriority());

	}

	public static void main(String args[]) {
		ThreadPriority m1 = new ThreadPriority();
		ThreadPriority m2 = new ThreadPriority();
		ThreadPriority m3 = new ThreadPriority();
		ThreadPriority m4 = new ThreadPriority();

		m1.setPriority(Thread.MIN_PRIORITY);
		m2.setPriority(Thread.MAX_PRIORITY);
		m3.setPriority(7);
		m4.setPriority(4);

		m1.start();
		m3.start();
		m4.start();
		try {
			m1.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m2.start();

	}

}
