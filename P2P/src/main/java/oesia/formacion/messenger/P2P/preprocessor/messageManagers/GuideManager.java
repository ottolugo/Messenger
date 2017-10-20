package oesia.formacion.messenger.P2P.preprocessor.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.GuidedMessage;
import oesia.formacion.messenger.P2P.domain.managers.PreprocessorMessageManager;

/**
 * this manager is in charge of the Guide Messages only, on its method it check
 * if the message is good to go and send it to the right fifoManager
 * 
 */
public class GuideManager extends MessageManager {

	public GuideManager(int limitTime, String user) {
		super(limitTime, user);
	}

	@Override
	public void manageMessage(Message message) {
		if (this.isDateValid(message) && this.isForMe(message)) {
			PreprocessorMessageManager.receiveBroadcast((GuidedMessage) message);
		}

	}

	private boolean isForMe(Message message) {
		GuidedMessage guided = (GuidedMessage) message;
		if (guided.getUserDestinity().equals(this.getUser())) {
			return true;
		} else {
			return false;
		}
	}

}