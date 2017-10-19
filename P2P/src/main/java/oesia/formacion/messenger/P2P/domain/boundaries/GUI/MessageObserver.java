package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

public interface MessageObserver {
	/**
	 * Executed when the messages status is changed
	 * 
	 * @param status
	 */
	public void update(MessageStatus status);
}
