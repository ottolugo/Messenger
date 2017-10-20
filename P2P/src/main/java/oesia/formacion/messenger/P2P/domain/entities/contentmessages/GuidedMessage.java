package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class GuidedMessage extends UserMessage implements Serializable {

	private String userDestinity;
	private static final long serialVersionUID = -3251749199683153295L;

	public GuidedMessage(Code code, String contenido, String userDestinity) {
		super(code, contenido);
		this.userDestinity = userDestinity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((userDestinity == null) ? 0 : userDestinity.hashCode());
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
		GuidedMessage other = (GuidedMessage) obj;
		if (userDestinity == null) {
			if (other.userDestinity != null)
				return false;
		} else if (!userDestinity.equals(other.userDestinity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " userDestinity=" + userDestinity + ".";
	}

	public String getUserDestinity() {
		return userDestinity;
	}

	public void setUserDestinity(String userDestinity) {
		this.userDestinity = userDestinity;
	}

	@Override
	public MessageType getType() {
		return MessageType.GUIDED;
	}

}
