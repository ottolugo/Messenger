package oesia.formacion.messenger.P2P.domain.usecases;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.configuration.CacheConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.configuration.LoadConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.ObservableUserMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedUserList;

public class MessageServiceImpl implements MessageService {

	public MessageServiceImpl() {
	}

	@Override
	public void sendMessage(ObservableUserMessage msg) {
		CacheConfiguration.getMessageCache().addMessage(msg);
		SocketConfiguration.getService().sendMessage(msg.getMessage());
	}

	@Override
	public void msgSubscribe(GUIObserver<UserMessage> obs) {
		NotifierReceivedMessage.getInstance().addObserver(obs);

	}

	@Override
	public void listSubscribe(GUIObserver<List<String>> obs) {
		NotifierReceivedUserList.getInstance().addObserver(obs);
	}

	@Override
	public String whoami() {
		return Configuration.getConfiguration().getWhoami();
	}

	@Override
	public void start() {
		LoadConfiguration.start();
	}

}
