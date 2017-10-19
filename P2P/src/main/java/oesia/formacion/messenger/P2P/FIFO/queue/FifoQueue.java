package oesia.formacion.messenger.P2P.FIFO.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.socket.reciever.MessagePortListener;

public class FifoQueue {
	/**
	 * Implementation of the First In First Out queue, when an external resource
	 * get a message out of it, FifoQueue gives the first object on line and
	 * removes it so the next iteration can do the same thing and all the
	 * elements will advance to the first position
	 * 
	 */
	private static List<Message> fifo = new LinkedList<Message>();
	private static final Logger LOG = Logger.getLogger(MessagePortListener.class.getName());

	public static void addMessage(Message message) {
		LOG.log(Level.INFO, "Message recived: " + message);
		fifo.add(message);
	}

	public static Message getMessage() {
		Message message = fifo.get(0);
		fifo.remove(0);
		LOG.log(Level.INFO, "Message requested: " + message);
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
