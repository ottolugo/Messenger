package oesia.formacion.messenger.P2P.domain.entities.advicemessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class KeepAliveMessage extends Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8515746137849974358L;
	// TODO Code

	@Override
	public MessageType getType() {
		return MessageType.KEEPALIVE;
	}

}
