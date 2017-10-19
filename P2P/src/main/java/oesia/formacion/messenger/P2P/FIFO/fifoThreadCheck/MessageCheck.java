package oesia.formacion.messenger.P2P.FIFO.fifoThreadCheck;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.FIFO.messageManagers.AckManager;
import oesia.formacion.messenger.P2P.FIFO.messageManagers.BroadcastManager;
import oesia.formacion.messenger.P2P.FIFO.messageManagers.GuideManager;
import oesia.formacion.messenger.P2P.FIFO.messageManagers.KeepAliveManager;
import oesia.formacion.messenger.P2P.FIFO.messageManagers.MessageManager;
import oesia.formacion.messenger.P2P.FIFO.queue.FifoQueue;
import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;
import oesia.formacion.messenger.P2P.socket.reciever.MessagePortListener;

/**
 * 
 * this thread check the fifo queue and depending on the message calls a
 * MessageManager to do its job(manageMessage)
 * 
 * @author jcagigas
 *
 */
public class MessageCheck extends Thread {
	private static final Logger LOG = Logger.getLogger(MessagePortListener.class.getName());
	private Map<MessageType, MessageManager> messageManagers;
	private LocalConfiguration config = Configuration.getConfiguration();
	private int limitTime;
	private String user;

	/*
	 * Constructor which main function is to instance all the Message Managers
	 */
	public MessageCheck() {
		this.limitTime = config.getMessageTimeout();
		this.user = config.getWhoami();
		messageManagers = new HashMap<MessageType, MessageManager>();
		messageManagers.put(MessageType.ACK, new AckManager(limitTime, user));
		messageManagers.put(MessageType.BROADCAST, new BroadcastManager(limitTime, user));
		messageManagers.put(MessageType.GUIDED, new GuideManager(limitTime, user));
		messageManagers.put(MessageType.KEEPALIVE, new KeepAliveManager(limitTime, user));

	}

	@Override
	public void run() {
		while (true) {
			if (FifoQueue.gotMessages()) {
				Message message = FifoQueue.getMessage();
				MessageManager messageManager = this.messageManagers.get(message.getType());
				messageManager.manageMessage(message);
				LOG.log(Level.FINE, "message sent" + messageManager);
			}
		}
	}

}
