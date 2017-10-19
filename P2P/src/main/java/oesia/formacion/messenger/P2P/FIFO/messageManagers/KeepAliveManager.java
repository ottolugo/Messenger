package oesia.formacion.messenger.P2P.FIFO.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

/**
 * this manager is in charge of the KeepAlive Messages only, on its method it
 * just sends the message to the right fifoManager with no validation
 * 
 */
public class KeepAliveManager extends MessageManager {

	public KeepAliveManager(int limitTime, String user) {
		super(limitTime, user);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manageMessage(Message message) {
		FIFOMessageManager.receiveKeepAlive((KeepAliveMessage) message);

	}

}
