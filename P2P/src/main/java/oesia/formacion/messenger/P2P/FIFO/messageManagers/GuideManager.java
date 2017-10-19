package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.GuidedMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class GuideManager extends MessageManager {
	/**
	 * this manager is in charge of the Guide Messages only, on its method it
	 * check if the message is good to go and send it to the right fifoManager
	 * 
	 * @param limitTime
	 * @param user
	 */

	public GuideManager(int limitTime, String user) {
		super(limitTime, user);
	}

	@Override
	public void manageMessage(Message message) {
		if (this.isValid(message)) {
			FIFOMessageManager.receiveBroadcast((GuidedMessage) message);
		}

	}

}
