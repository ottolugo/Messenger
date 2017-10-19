package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface FIFOservice {
	/**
	 * Starts the fifo service with the specified user and the set timeout
	 * 
	 * @param user
	 * @param timeout
	 */
	public void startService(String user, int timeout);

	/**
	 * Put message in fifoStack
	 * 
	 * @param msg
	 */
	public void put(Message msg);
}
