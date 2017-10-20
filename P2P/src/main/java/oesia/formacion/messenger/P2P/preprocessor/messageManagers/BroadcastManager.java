package oesia.formacion.messenger.P2P.preprocessor.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.managers.PreprocessorMessageManager;

/**
 * this manager is in charge of the Broadcast Messages only, on its method it
 * check if the message is good to go and send it to the right fifoManager
 * 
 */
public class BroadcastManager extends MessageManager {

	public BroadcastManager(int limitTime, String user) {
		super(limitTime, user);
	}

	@Override
	public void manageMessage(Message message) {
		if (this.isDateValid(message)) {
			PreprocessorMessageManager.receiveBroadcast((UserMessage) message);
		}

	}

}