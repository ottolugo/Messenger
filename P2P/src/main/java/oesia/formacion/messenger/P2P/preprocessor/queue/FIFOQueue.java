package oesia.formacion.messenger.P2P.preprocessor.queue;

import java.util.LinkedList;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.socket.reciever.MessagePortListener;

/**
 * Implementation of the First In First Out queue, when an external resource get
 * a message out of it, FifoQueue gives the first object on line and removes it
 * so the next iteration can do the same thing and all the elements will advance
 * to the first position
 * 
 * @author jcagigas
 *
 */
public class FIFOQueue {
	private LinkedList<Message> fifo;
	@SuppressWarnings("unused")
	private final Logger LOG;

	
	
	public FIFOQueue() {
		fifo = new LinkedList<Message>();
		LOG = Logger.getLogger(MessagePortListener.class.getName());
	}

	/**
	 * add message to the queue
	 * 
	 * @param message
	 */
	public void addMessage(Message message) {
		//LOG.log(Level.INFO, "Message recived: " + message);
		fifo.addLast(message);
	}

	/**
	 * get the first messsage of the queue and removes it
	 * 
	 * @return
	 */
	public Message getMessage() {
		Message message = fifo.get(0);
		fifo.removeFirst();
		//LOG.log(Level.INFO, "Message requested: " + message);
		return message;
	}

	/**
	 * return true if the list got messages
	 * 
	 * @return
	 */
	public boolean gotMessages() {
		if (fifo.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
