package oesia.formacion.messenger.P2P.FIFO;

public class MessageManagerConfiguration {
	private static MessageCheck messageManager = null;

	public static MessageCheck startMessageManager() {
		if (messageManager == null) {
			messageManager = new MessageCheck();
			messageManager.start();
			// messageManager.start();
		}
		return messageManager;
	}

}
