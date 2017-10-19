package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;

public interface MessageService {
	/**
	 * Sends a message from the GUI to the P2P
	 * 
	 * @param msg
	 */
	public void sendMessage(BroadcastMessage msg);
}
