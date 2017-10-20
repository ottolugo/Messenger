package oesia.formacion.messenger.P2P.FIFO.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

/**
 * this manager is in charge of the ACKmessages only, on its method it check if
 * the message is good to go and send it to the right fifoManager
 * 
 */
public class AckManager extends MessageManager {

	public AckManager(int limitTime, String user) {
		super(limitTime, user);

	}

	@Override
	public void manageMessage(Message message) {
		if (this.itIsNotMe(message) && this.isDateValid(message) && this.notForMe(message)) {
			FIFOMessageManager.receiveACK((ACKMessage) message);
		}
	}

	private boolean notForMe(Message message) {
		ACKMessage ack = (ACKMessage) message;
		if (ack.getCodeRespost().getUser().equals(this.getUser())) {
			return false;
		} else {
			return true;
		}
	}

}
