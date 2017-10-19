package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

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
