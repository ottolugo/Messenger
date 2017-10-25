package oesia.formacion.messenger.P2P.domain.usecases;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.ObservableUserMessage;
import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.configuration.LoadConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.RepositoryConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedUserList;
import oesia.formacion.messenger.P2P.domain.util.MessageCache;

public class MessageServiceImpl implements MessageService {

	public MessageServiceImpl() {
	}

	@Override
	public void sendMessage(ObservableUserMessage msg) {
		MessageCache.getCache().addMessage(msg);
		SocketConfiguration.getService().sendMessage(msg.getMessage());
		// No borres esto
		RepositoryConfiguration.getService().logMessage(msg.getMessage());
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
