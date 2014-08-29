package sandbox.thread;

public class RunningThread extends Thread {

	private boolean loop = true;

	public void stopRunning(){
		loop = false;
	}

	@Override
	public void run() {
		while (loop) {
			try {
				System.out.println("待つよ！");
				Thread.sleep(10000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
