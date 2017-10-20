package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public interface MessageService {
	/**
	 * Sends a message from the GUI to the P2P
	 * 
	 * @param msg
	 */
	public void sendMessage(UserMessage msg);
}
