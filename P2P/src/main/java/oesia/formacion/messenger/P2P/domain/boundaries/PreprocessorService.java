package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface PreprocessorService {
	/**
	 * Starts the preprocessor service
	 * 
	 * @param user
	 * @param timeout
	 */
	public void startService();

	/**
	 * Put message in fifoStack
	 * 
	 * @param msg
	 */
	public void put(Message msg);
}
