package oesia.formacion.messenger.P2P.domain.boundaries.externals;

import oesia.formacion.messenger.P2P.domain.managers.UserListNotifierManager;

public class UserListObserverManagerImpl implements UserListObserverManager {

	@Override
	public void addObserver(UserListObserver newObserver) {
		UserListNotifierManager.getInstance().add(newObserver);

	}

	@Override
	public void dropObserver(UserListObserver oldObserver) {
		UserListNotifierManager.getInstance().drop(oldObserver);

	}

}
