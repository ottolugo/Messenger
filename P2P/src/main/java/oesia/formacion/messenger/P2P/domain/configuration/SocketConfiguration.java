package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.boundaries.SocketService;
import oesia.formacion.messenger.P2P.socket.bonduaries.SocketServiceImpl;

public class SocketConfiguration {
	private static SocketService service;

	public SocketService getService() {
		if (service == null) {
			service = SocketServiceImpl.getInstance();
		}
		return service;
	}
}
