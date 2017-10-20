package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class UserMessage extends Message implements Serializable {

	private static final long serialVersionUID = -6623249859711995672L;
	private String contenido;
	private MessageStatus status;
	
	public UserMessage(){
		super();
	}

	public UserMessage(Code code, String contenido) {
		super(code);
		this.contenido = contenido;
		this.status = MessageStatus.NEW;
	}

	@Override
	public MessageType getType() {
		return MessageType.BROADCAST;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contenido == null) ? 0 : contenido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMessage other = (UserMessage) obj;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		return true;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return super.toString() + " contenido=" + contenido + ".";
	}

}
