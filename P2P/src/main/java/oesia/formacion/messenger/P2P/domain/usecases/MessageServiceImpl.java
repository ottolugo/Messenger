package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.configuration.CacheConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;

public class MessageServiceImpl implements MessageService {
	
	public MessageServiceImpl() {
	}

	@Override
	public void sendMessage(BroadcastMessage msg) {
		CacheConfiguration.getMessageCache().addMessage(msg);
		SocketConfiguration.getService().sendMessage(msg);
	}

}
