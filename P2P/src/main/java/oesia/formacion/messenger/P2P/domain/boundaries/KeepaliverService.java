package oesia.formacion.messenger.P2P.domain.boundaries;

public interface KeepaliverService {
	/**
	 * Starts the keepaliver service
	 * 
	 * @param user
	 * @param timeout
	 */
	public void startService();
}
