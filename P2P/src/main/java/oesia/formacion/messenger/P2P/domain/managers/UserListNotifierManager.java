package oesia.formacion.messenger.P2P.domain.managers;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.boundaries.externals.UserListObserver;

public class UserListNotifierManager implements ObserNotifier<UserListObserver, List<String>> {

	private static UserListNotifierManager instance = null;

	private List<UserListObserver> observers;

	public static UserListNotifierManager getInstance() {
		if (instance == null) {
			instance = new UserListNotifierManager();

		}
		return instance;
	}

	@Override
	public void add(UserListObserver value) {
		observers.add(value);

	}

	@Override
	public void drop(UserListObserver value) {
		observers.remove(value);

	}

	@Override
	public void notifyAll(List<String> value) {
		for (UserListObserver userListObserver : observers) {
			userListObserver.notify(value);
		}

	}

	private UserListNotifierManager() {
		observers = new ArrayList<UserListObserver>();
	}

}
