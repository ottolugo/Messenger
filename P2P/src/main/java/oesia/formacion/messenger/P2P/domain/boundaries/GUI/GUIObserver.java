package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

public interface GUIObserver<T> {
	/**
	 * Executed when a message is received or the user list is updated
	 * 
	 * @param obj
	 */
	public void notify(T obj);
}
