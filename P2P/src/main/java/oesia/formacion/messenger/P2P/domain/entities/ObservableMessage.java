package oesia.formacion.messenger.P2P.domain.entities;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageObserver;

public interface ObservableMessage {
	/**
	 * Notifies the specified observer
	 * 
	 * @param obs
	 */
	public void notify(MessageObserver obs);

	/**
	 * notifies all observers
	 */
	public void allNotify();

	/**
	 * adds an observer
	 * 
	 * @param obs
	 */
	public void addObserver(MessageObserver obs);

	/**
	 * drops an observer
	 * 
	 * @param obs
	 */
	public void dropObserver(MessageObserver obs);
}
