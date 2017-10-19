package oesia.formacion.messenger.P2P.FIFO;

public class MessageManagerConfiguration {
	private static Fifo fifoStack = null;

	public static Fifo startMessageManager(int time, String user) {
		if (fifoStack == null) {
			fifoStack = new Fifo(time, user);
			fifoStack.start();
			// messageManager.start();
		}
		return fifoStack;
	}

}
