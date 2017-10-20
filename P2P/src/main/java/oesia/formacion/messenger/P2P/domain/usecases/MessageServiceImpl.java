package oesia.formacion.messenger.P2P.domain.usecases;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.configuration.CacheConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierRecievedMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierRecievedUserList;

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
		NotifierRecievedMessage.getInstance().addObserver(obs);

	}

	@Override
	public void listSubscribe(GUIObserver<List<String>> obs) {
		NotifierRecievedUserList.getInstance().addObserver(obs);
	}

	@Override
	public String whoami() {
		return Configuration.getConfiguration().getWhoami();
	}

}
