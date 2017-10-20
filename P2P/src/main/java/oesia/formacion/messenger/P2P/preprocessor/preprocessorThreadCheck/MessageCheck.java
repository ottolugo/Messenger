package oesia.formacion.messenger.P2P.preprocessor.preprocessorThreadCheck;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.AckManager;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.BroadcastManager;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.FIFOQueueManager;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.GuideManager;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.KeepAliveManager;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.MessageManager;
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
	@SuppressWarnings("unused")
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
			try {
				//El sleep se introduce para que no se cuelgue el hilo al hacer espera activa
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (FIFOQueueManager.getFIFOQueue().gotMessages()) {
				Message message = FIFOQueueManager.getFIFOQueue().getMessage();
				MessageManager messageManager = this.messageManagers.get(message.getType());
				if (messageManager.itIsNotMe(message)) {
					messageManager.manageMessage(message);
					//LOG.log(Level.FINE, "message sent" + messageManager);
				} else {
					//LOG.log(Level.INFO, "message received but not sent" + messageManager);
				}
			}
		}
	}

}
