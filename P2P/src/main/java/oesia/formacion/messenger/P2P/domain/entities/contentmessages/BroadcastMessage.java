package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.io.Serializable;
import java.util.ArrayList;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageObserver;
import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;
import oesia.formacion.messenger.P2P.domain.entities.ObservableMessage;

public class BroadcastMessage extends Message implements Serializable, ObservableMessage {

	private static final long serialVersionUID = -6623249859711995672L;
	private String contenido;
	private MessageStatus status;
	private ArrayList<MessageObserver> observers;

	public BroadcastMessage(Code code, String contenido) {
		super(code);
		this.contenido = contenido;
		this.status = MessageStatus.NEW;
		this.observers = new ArrayList<MessageObserver>();
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
		BroadcastMessage other = (BroadcastMessage) obj;
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
		allNotify();
	}

	@Override
	public String toString() {
		return "BroadcastMessage [contenido=" + contenido + ", status=" + status + "]";
	}

	@Override
	public void notify(MessageObserver obs) {
		if (observers.contains(obs)) {
			obs.update(status);
		}
	}

	@Override
	public void allNotify() {
		for (MessageObserver messageObserver : observers) {
			messageObserver.update(status);
		}
	}

	@Override
	public void addObserver(MessageObserver obs) {
		observers.add(obs);

	}

	@Override
	public void dropObserver(MessageObserver obs) {
		observers.remove(obs);
	}

}
