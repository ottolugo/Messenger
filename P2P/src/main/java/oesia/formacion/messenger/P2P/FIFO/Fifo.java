package oesia.formacion.messenger.P2P.FIFO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;

public class Fifo extends Thread {
	private List<Message> fifo;
	private int limitTime;
	private String user;
	private Map<MessageType, MessageManager> messageManagers;

	public Fifo(int limitTime, String user) {
		fifo = new ArrayList<Message>();
		this.limitTime = limitTime;
		this.user = user;

		messageManagers = new HashMap<MessageType, MessageManager>();
		messageManagers.put(MessageType.ACK, new AckManager(limitTime, user));
		messageManagers.put(MessageType.BROADCAST, new BroadcastManager(limitTime, user));
		messageManagers.put(MessageType.GUIDED, new GuideManager(limitTime, user));
		messageManagers.put(MessageType.KEEPALIVE, new KeepAliveManager(limitTime, user));

	}

	public void addMessage(Message message) {
		fifo.add(message);
	}

	public Message getMessage() {
		Message message = fifo.get(0);
		fifo.remove(0);
		return message;
	}

	@Override
	public void run() {
		while (true) {
			if (fifo.size() > 0) {
				Message message = getMessage();
				MessageManager messageManager = this.messageManagers.get(message.getType());
				messageManager.manageMessage(message);
			}
		}
	}

}
