package oesia.formacion.messenger.P2P.domain.entities.advicemessages;

import java.io.Serializable;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class ACKMessage extends Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 132496653241888073L;
	
	private Code codeRespost;

	public Code getCodeRespost() {
		return codeRespost;
	}

	public void setCodeRespost(Code codeRespost) {
		this.codeRespost = codeRespost;
	}

	@Override
	public MessageType getType() {
		return MessageType.ACK;
	}
	

	@Override
	public String toString() {
		return "ACKMessage [codeRespost=" + codeRespost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeRespost == null) ? 0 : codeRespost.hashCode());
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
		if (codeRespost == null) {
			if (other.codeRespost != null)
				return false;
		} else if (!codeRespost.equals(other.codeRespost))
			return false;
		return true;
	}

}
