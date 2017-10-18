package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class BroadcastMessage extends Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6623249859711995672L;
	// TODO Code

	@Override
	public MessageType getType() {
		return MessageType.BROADCAST;
	}
}
