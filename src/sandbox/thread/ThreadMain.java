package sandbox.thread;

public class ThreadMain {

	public static void main(String[] args) {

//		final RunningThread rt = new RunningThread();
//
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			public void run () {
//				rt.stopRunning();
//				System.out.println("押された！");
//			}
//		});
//
//		System.out.println("動かすよ！");
//		rt.start();
//		System.out.println("動かした！");


		final Thread main = Thread.currentThread();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Starting shutdown...");
				System.out.flush();
				main.interrupt();
				try {
					main.join();
				} catch (InterruptedException e) {
					// no operation
				}
				System.out.println("Done.");
				System.out.flush();
			}
		});
		int i = 0;
		while (!Thread.interrupted()) {
			System.out.println(++i);
			System.out.flush();
		}
		System.out.println("Interrupted!!");
		System.out.flush();
	}

}
