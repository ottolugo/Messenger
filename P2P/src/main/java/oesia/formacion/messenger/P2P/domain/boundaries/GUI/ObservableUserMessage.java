package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public interface ObservableUserMessage {
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

	/**
	 * Gets the observed message (we need encapsulation to avoid sending full observable messages)
	 * 
	 * @return UserMessage
	 */
	public UserMessage getMessage();

	/**
	 * Sets status of message and notifies the observers of the change
	 * 
	 * @param status
	 */
	public void setStatus(MessageStatus status);
}
