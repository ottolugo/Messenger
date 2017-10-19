package oesia.formacion.messenger.P2P.FIFO;

public class MessageFactory {

	private static MessageManager ack = null;
	private static MessageManager broad = null;
	private static MessageManager guide = null;
	private static MessageManager keep = null;

	public static MessageManager getAckManager(int limitTime, String user) {
		if (ack == null) {
			ack = new AckManager(limitTime, user);
		}
		return ack;
	}

	public static MessageManager getBroacastManager(int limitTime, String user) {
		if (broad == null) {
			broad = new BroadcastManager(limitTime, user);
		}
		return broad;
	}

	public static MessageManager getGuidedmanager(int limitTime, String user) {
		if (guide == null) {
			guide = new GuideManager(limitTime, user);
		}
		return guide;
	}

	public static MessageManager getKeepAliveManager(int limitTime, String user) {
		if (keep == null) {
			keep = new KeepAliveManager(limitTime, user);
		}
		return keep;
	}
}
