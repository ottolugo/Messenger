package oesia.formacion.messenger.P2P.socket.senders;

import java.util.Stack;

public class SendMessageFIFO implements Runnable {

	private static SendMessageFIFO instance;
	private Stack<Runnable> todoList;

	private SendMessageFIFO() {
		todoList = new Stack<Runnable>();
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
		todoList.push(sender);
	}

	@Override
	public void run() {
		while (true) {
			if (!todoList.isEmpty()) {
				todoList.pop().run();
			}
			try {
				// Para evitar que se colapse
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}

	}

}
