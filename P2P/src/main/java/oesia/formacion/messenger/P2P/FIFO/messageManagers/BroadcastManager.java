package oesia.formacion.messenger.P2P.FIFO.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class BroadcastManager extends MessageManager {
	/**
	 * this manager is in charge of the Broadcast Messages only, on its method
	 * it check if the message is good to go and send it to the right
	 * fifoManager
	 * 
	 * @param limitTime
	 * @param user
	 */

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
