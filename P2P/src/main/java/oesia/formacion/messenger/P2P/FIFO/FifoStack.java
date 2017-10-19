package oesia.formacion.messenger.P2P.domain.FIFO;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public class FifoStack {
	private List<Message> messageList;

	/**
	 * 
	 */
	public FifoStack() {
		this.messageList = new ArrayList<Message>();
	}

	public void addMessage(Message message) {
		messageList.add(message);
	}

	public void removeMessage(Message message) {
		messageList.remove(message);
	}

	public Message getMessage() {
		Message message = messageList.get(0);
		removeMessage(messageList.get(0));
		return message;
	}

}
