package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.canceler.Canceler;

public class CancelerConfiguration {
	private static Canceler canceler = null;

	public static Canceler startCanceler() {
		if (canceler == null) {
			canceler = new Canceler();
			canceler.start();
		}
		return canceler;
	}
}
