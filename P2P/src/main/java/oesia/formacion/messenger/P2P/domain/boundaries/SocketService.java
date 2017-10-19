package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface SocketService {
	/**
	 * Sends a message to the socket
	 * @param msg
	 */
	public void sendMessage(Message msg);
}
