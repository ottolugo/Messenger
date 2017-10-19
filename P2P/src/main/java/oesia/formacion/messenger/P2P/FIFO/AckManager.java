package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class AckManager extends MessageManager {

	public AckManager(int limitTime, String user) {
		super(limitTime, user);

	}

	@Override
	public void manageMessage(Message message) {
		if (this.isValid(message)) {
			FIFOMessageManager.receiveACK((ACKMessage) message);
		}
	}

}
