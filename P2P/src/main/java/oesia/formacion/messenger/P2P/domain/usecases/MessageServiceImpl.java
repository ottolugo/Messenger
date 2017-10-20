package oesia.formacion.messenger.P2P.domain.usecases;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.configuration.CacheConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class MessageServiceImpl implements MessageService {
	
	public MessageServiceImpl() {
	}

	@Override
	public void sendMessage(UserMessage msg) {
		CacheConfiguration.getMessageCache().addMessage(msg);
		SocketConfiguration.getService().sendMessage(msg);
	}

	@Override
	public void msgSubscribe(GUIObserver<UserMessage> obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listSubscribe(GUIObserver<List<String>> obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String whoami() {
		// TODO Auto-generated method stub
		return null;
	}

}
