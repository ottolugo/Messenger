package oesia.formacion.messenger.P2P.preprocessor.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.usecases.UsecaseFactory;
import oesia.formacion.messenger.P2P.domain.util.DateUtil;

/**
 * this manager is in charge of the ACKmessages only, on its method it check if the message is good to go and send it to
 * the right fifoManager
 * 
 */
public class AckManager extends MessageManager {

	public AckManager(int limitTime, String user) {
		super(limitTime, user);

	}

	@Override
	public void manageMessage(Message message) {
		if (DateUtil.isDateValid(message) && isForMe(message)) {
			UsecaseFactory.getProcessMessageUsecase(message).run();
		}
	}

	private boolean isForMe(Message message) {
		ACKMessage ack = (ACKMessage) message;
		if (ack.getCodeResponse().getUser().equals(this.getUser())) {
			return true;
		} else {
			return false;
		}
	}

}
