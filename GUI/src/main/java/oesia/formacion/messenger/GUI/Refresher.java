package oesia.formacion.messenger.GUI;

public class Refresher extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				sleep(1000);
				App.getApp().refreshFormat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
