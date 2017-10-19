package oesia.formacion.messenger.P2P.domain.boundaries.externals;

public interface UserListObserverManager {
	public void addObserver(UserListObserver newObserver);

	public void dropObserver(UserListObserver oldObserver);

}
