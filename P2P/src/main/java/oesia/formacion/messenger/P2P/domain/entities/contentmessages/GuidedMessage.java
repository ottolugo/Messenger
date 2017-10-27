package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class GuidedMessage extends UserMessage implements Serializable {
	private final String userDestination;
	private static final long serialVersionUID = -3251749199683153295L;

	public GuidedMessage() {
		super();
		userDestination = "";
	}

	public GuidedMessage(Code code, String contenido, String userDestinity) {
		super(code, contenido);
		this.userDestination = userDestinity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((userDestination == null) ? 0 : userDestination.hashCode());
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
		if (userDestination == null) {
			if (other.userDestination != null)
				return false;
		} else if (!userDestination.equals(other.userDestination))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " userDestination=" + userDestination + ".";
	}

	public String getUserDestination() {
		return userDestination;
	}

	@Override
	public MessageType getType() {
		return MessageType.GUIDED;
	}

}
