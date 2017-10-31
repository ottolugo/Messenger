package oesia.formacion.messenger.P2P.socket.senders;

import java.util.LinkedList;
import java.util.Queue;

public class SendMessageFIFO implements Runnable {

	private static SendMessageFIFO instance;
	private Queue<Runnable> todoList;

	private SendMessageFIFO() {
		todoList = new LinkedList<Runnable>();
	}

	public static SendMessageFIFO getInstance() {
		if (instance == null) {
			instance = new SendMessageFIFO();
		}
		return instance;
	}

	/**
	 * Para agregar envios a la pila
	 * 
	 * @param sender
	 */
	public void addWork(Runnable sender) {
		todoList.add(sender);
	}

	@Override
	public void run() {
		while (true) {
			if (!todoList.isEmpty()) {
				todoList.remove().run();
			}
			try {
				// Para evitar que se colapse
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}

	}

}
