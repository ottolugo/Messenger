package oesia.formacion.messenger.P2P.FIFO.messageManagers.config;

import oesia.formacion.messenger.P2P.FIFO.fifoThreadCheck.MessageCheck;

public class MessageManagerConfiguration {
	/**
	 * Singleton factory that initiates the thread
	 */
	private static MessageCheck messageManager = null;

	public static MessageCheck startMessageManager() {
		if (messageManager == null) {
			messageManager = new MessageCheck();
			messageManager.start();
		}
		return messageManager;
	}

}
