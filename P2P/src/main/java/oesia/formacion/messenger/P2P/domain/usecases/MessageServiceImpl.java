package oesia.formacion.messenger.P2P.domain.usecases;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.ObservableUserMessage;
import oesia.formacion.messenger.P2P.domain.configuration.LoadConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
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
		UsecaseFactory.getSendMessageUsecase(msg.getMessage()).run();
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
		return LocalConfiguration.getWhoami();
	}

	@Override
	public void start() {
		LoadConfiguration.start();
	}

}
