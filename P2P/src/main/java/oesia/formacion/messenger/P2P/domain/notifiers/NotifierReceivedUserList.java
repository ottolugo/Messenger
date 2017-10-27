package oesia.formacion.messenger.P2P.domain.notifiers;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;

public class NotifierReceivedUserList implements DomainNotifier<List<String>, GUIObserver<List<String>>> {

	private static NotifierReceivedUserList instance = null;

	private List<GUIObserver<List<String>>> observers = null;

	private NotifierReceivedUserList() {
		observers = new ArrayList<GUIObserver<List<String>>>();
	}

	public static NotifierReceivedUserList getInstance() {
		if (instance == null) {
			instance = new NotifierReceivedUserList();
		}
		return instance;
	}

	@Override
	public void notify(List<String> notification) {
		for (GUIObserver<List<String>> guiObserver : observers) {
			guiObserver.update(notification);
		}

	}

	@Override
	public void addObserver(GUIObserver<List<String>> observer) {
		observers.add(observer);

	}

	@Override
	public void dropObserver(GUIObserver<List<String>> observer) {
		observers.remove(observer);

	}

}
