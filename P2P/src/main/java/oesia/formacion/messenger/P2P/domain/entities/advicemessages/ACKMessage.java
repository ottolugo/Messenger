package oesia.formacion.messenger.P2P.domain.entities.advicemessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class ACKMessage extends Message implements Serializable {
	private static final long serialVersionUID = 132496653241888073L;

	private final Code codeResponse;

	public ACKMessage() {
		super();
		codeResponse = null;
	}

	public ACKMessage(Code code, Code codeResponse) {
		super(code);
		this.codeResponse = codeResponse;
	}

	public Code getCodeResponse() {
		return codeResponse;
	}

	@Override
	public MessageType getType() {
		return MessageType.ACK;
	}

	@Override
	public String toString() {
		return super.toString(", codeResponse=" + codeResponse);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeResponse == null) ? 0 : codeResponse.hashCode());
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
		ACKMessage other = (ACKMessage) obj;
		if (codeResponse == null) {
			if (other.codeResponse != null)
				return false;
		} else if (!codeResponse.equals(other.codeResponse))
			return false;
		return true;
	}

}
