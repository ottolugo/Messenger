package oesia.formacion.messenger.P2P.preprocessor.queue;

import java.util.LinkedList;

import oesia.formacion.messenger.P2P.domain.entities.Message;

/**
 * Implementation of the First In First Out queue, when an external resource get a message out of it, FifoQueue gives
 * the first object on line and removes it so the next iteration can do the same thing and all the elements will advance
 * to the first position
 * 
 * @author jcagigas
 *
 */
public class FIFOQueue {
	private static FIFOQueue single;
	
	public static FIFOQueue getFIFO(){
		if(single == null){
			single = new FIFOQueue();
		}
		return single;
	}
	
	private LinkedList<Message> fifo;

	private FIFOQueue() {
		fifo = new LinkedList<Message>();
	}

	/**
	 * add message to the queue
	 * 
	 * @param message
	 */
	public void addMessage(Message message) {
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
		return message;
	}

	/**
	 * return true if the list got messages
	 * 
	 * @return
	 */
	public boolean gotMessages() {
		return (fifo.size()>0);
	}
}
