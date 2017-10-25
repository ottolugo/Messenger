package oesia.formacion.messenger.P2P.canceler;

import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.util.MessageCache;

public class Canceler extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				sleep((Configuration.getConfiguration().getMessageTimeout()) * 1000);
				MessageCache.getCache().checkMessages();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
