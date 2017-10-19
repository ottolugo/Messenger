package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

public class MessageFactory {
	MessageService service;

	/**
	 * Returns the message service for the GUI to send messages to the P2P
	 * 
	 * @return
	 */
	public MessageService getMessageService() {
		if (service == null) {

		}
		return service;
	}
}
