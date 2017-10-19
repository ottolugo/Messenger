package oesia.formacion.messenger.P2P.domain.boundaries.externals;

public interface MessageObserverManager {
	public void addObserver(MessageObserver newObserver);
	public void dropObserver(MessageObserver oldObserver);

}
