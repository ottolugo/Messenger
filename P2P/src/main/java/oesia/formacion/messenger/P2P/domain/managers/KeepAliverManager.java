package oesia.formacion.messenger.P2P.domain.managers;

import oesia.formacion.messenger.P2P.domain.configuration.KeepAliveConfiguration;

public class KeepAliverManager {

	/**
	 * Used by the keepaliver to make us send a keepalive message
	 */
	public static void sendKeepAlive() {
		KeepAliveConfiguration.newKeepAlive();
	}

}
