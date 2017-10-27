package oesia.formacion.messenger.P2P.domain.notifiers;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class NotifierReceivedMessage implements DomainNotifier<UserMessage, GUIObserver<UserMessage>> {

	private static NotifierReceivedMessage instance = null;
	private List<GUIObserver<UserMessage>> observers = null;

	private NotifierReceivedMessage() {
		observers = new ArrayList<GUIObserver<UserMessage>>();
	}

	public static NotifierReceivedMessage getInstance() {
		if (instance == null) {
			instance = new NotifierReceivedMessage();
		}
		return instance;
	}

	@Override
	public void notify(UserMessage notification) {
		for (GUIObserver<UserMessage> guiObserver : observers) {
			guiObserver.update(notification);
		}
	}

	@Override
	public void addObserver(GUIObserver<UserMessage> observer) {
		observers.add(observer);
	}

	@Override
	public void dropObserver(GUIObserver<UserMessage> observer) {
		observers.remove(observer);
	}

}
