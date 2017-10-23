package oesia.formacion.messenger.P2P.keepAliver;

import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.configuration.KeepAliveConfiguration;

public class KeepAliver extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				sleep((Configuration.getConfiguration().getKeepAliveTimeout()) * 1000);
				KeepAliveConfiguration.newKeepAlive();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
