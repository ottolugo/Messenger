package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface FIFOservice {
	/**
	 * Put message in fifoStack
	 * @param msg
	 */
	public void put(Message msg);
}
