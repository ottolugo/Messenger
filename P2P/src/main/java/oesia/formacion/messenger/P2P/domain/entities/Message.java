package oesia.formacion.messenger.P2P.domain.entities;

import java.io.Serializable;

public abstract class Message implements Serializable {
	private static final long serialVersionUID = -2685274736574581674L;
	private final Code code;

	public abstract MessageType getType();

	public Message() {
		code = null;
	}

	public Message(Code code) {
		this.code = code;
	}

	public Code getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "Message [type = " + getType() + " code=" + code + "]";
	}
	
	protected String toString(String within) {
		return "Message [type = " + getType() + " code=" + code + within + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
