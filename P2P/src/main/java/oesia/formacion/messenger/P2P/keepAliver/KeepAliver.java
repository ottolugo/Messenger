package oesia.formacion.messenger.P2P.keepAliver;

import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.managers.KeepAliverManager;

public class KeepAliver extends Thread {

	@Override
	public void run() {
		while (true) {
			try {
				this.wait((Configuration.getConfiguration().getKeepAliveTimeout()) * 1000);
				KeepAliverManager.sendKeepAlive();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
