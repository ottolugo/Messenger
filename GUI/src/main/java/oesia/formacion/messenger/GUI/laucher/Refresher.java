package oesia.formacion.messenger.GUI.laucher;

import oesia.formacion.messenger.GUI.App;

public class Refresher extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				sleep(400);
				App.getApp().refreshFormat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
