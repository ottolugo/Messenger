package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class GuidedMessage extends BroadcastMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3251749199683153295L;
	// TODO Code

	@Override
	public MessageType getType() {
		return MessageType.GUIDED;
	}
	
}
