package oesia.formacion.messenger.P2P.FIFO.messageManagers;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class KeepAliveManager extends MessageManager {
	/**
	 * this manager is in charge of the KeepAlive Messages only, on its method
	 * it just sends the message to the right fifoManager with no validation
	 * 
	 * @param limitTime
	 * @param user
	 */

	public KeepAliveManager(int limitTime, String user) {
		super(limitTime, user);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void manageMessage(Message message) {
		FIFOMessageManager.receiveKeepAlive((KeepAliveMessage) message);

	}

}
