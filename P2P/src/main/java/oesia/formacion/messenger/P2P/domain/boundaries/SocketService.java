package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface SocketService {

	/**
	 * starts the service to listen in the specified port
	 * 
	 * @param port
	 */
	public void startService(int port);

	/**
	 * Sends a message to the socket
	 * 
	 * @param msg
	 */
	public void sendMessage(Message msg);
}
