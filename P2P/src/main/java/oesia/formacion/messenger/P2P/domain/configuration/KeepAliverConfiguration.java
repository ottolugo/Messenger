package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.keepAliver.KeepAliver;

public class KeepAliverConfiguration {
	private static KeepAliver keepAliver = null;

	public static KeepAliver startKeepAliver() {
		if (keepAliver == null) {
			keepAliver = new KeepAliver();
			keepAliver.start();
		}
		return keepAliver;
	}
}
