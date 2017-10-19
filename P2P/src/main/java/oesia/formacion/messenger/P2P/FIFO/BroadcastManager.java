package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class BroadcastManager extends MessageManager {

	public BroadcastManager(int limitTime, String user) {
		super(limitTime, user);
	}

	@Override
	public void manageMessage(Message message) {
		if (this.isDateValid(message)) {
			FIFOMessageManager.receiveBroadcast((BroadcastMessage) message);
		}

	}

}
