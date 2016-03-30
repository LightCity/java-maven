package fuckjava;

public class DeadLockTest {
	
	static Object a = new Object();
	static Object b = new Object();
	
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				synchronized (a) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (b) {
						System.out.println("Thread 1");
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				synchronized (b) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (a) {
						System.out.println("Thread 1");
					}
				}
			}
		}).start();
	}

}
