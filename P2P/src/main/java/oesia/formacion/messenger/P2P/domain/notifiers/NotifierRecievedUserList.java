package oesia.formacion.messenger.P2P.domain.notifiers;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;

public class NotifierRecievedUserList implements DomainObservable<List<String>, GUIObserver<List<String>>> {

	private static NotifierRecievedUserList instance = null;

	private List<GUIObserver<List<String>>> observers = null;

	private NotifierRecievedUserList() {
		observers = new ArrayList<GUIObserver<List<String>>>();
	}

	public static NotifierRecievedUserList getInstance() {
		if (instance == null) {
			instance = new NotifierRecievedUserList();
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
