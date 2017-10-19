package oesia.formacion.messenger.P2P.FIFO;

import java.util.LinkedList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public class FifoQueue {
	private static List<Message> fifo = new LinkedList<Message>();

	public static void addMessage(Message message) {
		fifo.add(message);
	}

	public static Message getMessage() {
		Message message = fifo.get(0);
		fifo.remove(0);
		return message;
	}

	public static boolean gotMessages() {
		if (fifo.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
