package oesia.formacion.messenger.P2P.socket.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SocketThreadManager {

	private static List<Thread> activeSendMessageThreads = null;
	private static Map<Integer, Thread> activePortListenerThreads = null;
	private static Semaphore sendMessagePortSemaphore = null;

	private SocketThreadManager() {
	}

	/**
	 * Cuando se crea un thread para mandar un mensage
	 * 
	 * @param thread
	 */
	public void addSendMessageThread(Thread thread) {
		checkinitialiceSendMessageThreads();
		activeSendMessageThreads.add(thread);
	}

	public void dropSendMessageThread(Thread thread) {
		checkinitialiceSendMessageThreads();
		activeSendMessageThreads.remove(thread);
	}

	public List<Thread> getActiveSendMessageThreads() {
		return activeSendMessageThreads;
	}

	private void checkinitialiceSendMessageThreads() {
		if (activeSendMessageThreads == null) {
			activeSendMessageThreads = new ArrayList<Thread>();
		}

	}
}
