package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.GuidedMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class GuideManager extends MessageManager {

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
