package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public interface RepositoryService {
	/**
	 * Saves a message to the log; only broadcast messages and guided messages
	 * 
	 * @param msg
	 */
	public void logMessage(UserMessage msg);

	/**
	 * Load the configuration from the repository
	 * 
	 * @return LocalConfiguration
	 */
	public LocalConfiguration getConfiguration();
}
