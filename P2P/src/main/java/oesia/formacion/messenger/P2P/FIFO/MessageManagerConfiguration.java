package oesia.formacion.messenger.P2P.FIFO;

public class MessageManagerConfiguration {
	private static MessageManager messageManager = null;
	private static FifoStack fifoStack = null;

	public static MessageManager startMessageManager(int time, String user) {
		if (messageManager == null) {
			fifoStack = new FifoStack(time, user);
			fifoStack.start();
			// messageManager.start();
		}
		return messageManager;
	}

}
