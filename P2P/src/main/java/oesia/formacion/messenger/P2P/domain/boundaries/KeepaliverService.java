package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;

public interface KeepaliverService {
	/**
	 * Starts the keepaliver service
	 * 
	 * @param user
	 * @param timeout
	 */
	public void startService();

	/**
	 * Notifies keepaliver of a keepalive ack
	 * 
	 * @param msg
	 */
	public void notify(ACKMessage msg);
}
