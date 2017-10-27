package oesia.formacion.messenger.P2P.keepAliver;

import oesia.formacion.messenger.P2P.domain.configuration.KeepAliveConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class KeepAliver extends Thread {
	private int sleepTime;
	@Override
	public void run() {
		sleepTime = LocalConfiguration.getKeepAliveTimeout() * 1000;
		while (true) {
			try {
				sleep(sleepTime);
				KeepAliveConfiguration.newKeepAlive();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
