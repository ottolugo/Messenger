package oesia.formacion.messenger.P2P.domain.entities.advicemessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class KeepAliveMessage extends Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8515746137849974358L;

	public KeepAliveMessage(Code code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MessageType getType() {
		return MessageType.KEEPALIVE;
	}

}
