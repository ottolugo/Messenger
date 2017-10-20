package oesia.formacion.messenger.P2P.domain.boundaries;

public interface KeepAliverService {
	/**
	 * Starts the keepaliver service
	 * 
	 * @param user
	 * @param timeout
	 */
	public void startService();
}
