package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import oesia.formacion.messenger.P2P.domain.usecases.MessageServiceImpl;

public class MessageFactory {
	private static MessageService service;

	/**
	 * Returns the message service for the GUI to send messages to the P2P
	 * 
	 * @return
	 */
	public static MessageService getMessageService() {
		if (service == null) {
			service = new MessageServiceImpl();
		}
		return service;
	}
}
