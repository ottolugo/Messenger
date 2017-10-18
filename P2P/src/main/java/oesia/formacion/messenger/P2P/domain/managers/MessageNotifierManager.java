package oesia.formacion.messenger.P2P.domain.managers;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.externals.MessageObserver;
import oesia.formacion.messenger.P2P.domain.entities.Message;

public class MessageNotifierManager implements ObserNotifier<MessageObserver, Message> {

	private static MessageNotifierManager instance = null;

	private List<MessageObserver> observers;

	public static MessageNotifierManager getInstance() {
		if (instance == null) {
			instance = new MessageNotifierManager();

		}
		return instance;
	}

	@Override
	public void add(MessageObserver value) {
		observers.add(value);

	}

	@Override
	public void drop(MessageObserver value) {
		observers.remove(value);

	}

	@Override
	public void notifyAll(Message value) {
		for (MessageObserver userListObserver : observers) {
			userListObserver.notify(value);
		}

	}

	private MessageNotifierManager() {
		observers = new ArrayList<MessageObserver>();
	}

}
