package oesia.formacion.messenger.P2P.repository.manager;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public interface ManagerRepositoryService {
	
	/**
	 * @param msg
	 * @do: Insert a log in the file xml.
	 */
	public void insertLog(UserMessage msg);
	
	/**
	 * @return LocalConfiguration: get archive config.xml
	 */
	public LocalConfiguration loadXml();

}
