package oesia.formacion.messenger.P2P.FIFO;

import java.util.ArrayList;
import java.util.List;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public class FifoStack extends Thread {
	private List<Message> fifoStack;
	private int limitTime;
	private String user;

	public FifoStack(int limitTime, String user) {
		fifoStack = new ArrayList<Message>();
		this.limitTime = limitTime;
		this.user = user;
	}

	public void addMessage(Message message) {
		fifoStack.add(message);
	}

	public Message getMessage() {
		Message message = fifoStack.get(0);
		fifoStack.remove(0);
		return message;
	}

	@Override
	public void run() {
		while (true) {
			if (fifoStack.size() > 0) {
				Message message = getMessage();
				MessageManager messageManager;
				switch (message.getType()) {
				case ACK:
					messageManager = MessageFactory.getAckManager(limitTime, user);
					break;
				case BROADCAST:
					messageManager = MessageFactory.getBroacastManager(limitTime, user);
					break;
				case GUIDED:
					messageManager = MessageFactory.getGuidedmanager(limitTime, user);
					break;
				case KEEPALIVE:
					messageManager = MessageFactory.getKeepAliveManager(limitTime, user);
					break;
				default:
					messageManager = null;
					break;
				}
				messageManager.manageMessage(message);
			}
		}
	}

}
