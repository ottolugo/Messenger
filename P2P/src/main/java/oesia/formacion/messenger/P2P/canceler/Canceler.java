package oesia.formacion.messenger.P2P.canceler;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.util.MessageCache;

public class Canceler extends Thread {
	private int sleepTime;
	@Override
	public void run() {
		sleepTime = LocalConfiguration.getMessageTimeout() * 1000;
		while (true) {
			try {
				sleep(sleepTime);
				MessageCache.getCache().checkMessages();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
