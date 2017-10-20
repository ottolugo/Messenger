package oesia.formacion.messenger.P2P.keepAliver;

public class KeepAliverConfiguration {

	private static KeepAliver keepAliver = null;

	public static KeepAliver startKeepAlive() {
		if (keepAliver == null) {
			keepAliver = new KeepAliver();
			keepAliver.start();
		}
		return keepAliver;
	}

}
