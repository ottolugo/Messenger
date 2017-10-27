package oesia.formacion.messenger.P2P.domain.managers;

import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.configuration.KeepAliveConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.RepositoryConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedMessage;
import oesia.formacion.messenger.P2P.domain.usecases.UsecaseFactory;
import oesia.formacion.messenger.P2P.domain.util.CodeGenerator;
import oesia.formacion.messenger.P2P.domain.util.MessageCache;
import oesia.formacion.messenger.P2P.logger.LogGet;

/**
 * This class is used by the FIFO to send messages to the domain
 * 
 * @author EXTamarino
 *
 */
public class PreprocessorMessageManager {
	private static final Logger LOG = LogGet.getLogger(PreprocessorMessageManager.class);

	public static void receiveMessage(Message msg) {
		switch (msg.getType()) {
		case BROADCAST:
		case GUIDED:
			receiveBroadcast((UserMessage) msg);
			break;
		case ACK:
			receiveACK((ACKMessage) msg);
			break;
		case KEEPALIVE:
			receiveKeepAlive((KeepAliveMessage) msg);
			break;
		default:
			LOG.warning("Wrong input on ProcessMessageUsecase");
			break;
		}
	}

	/**
	 * Sends the broadcast message from the preprocessor to the domain It sends the broadcasted message to the gui
	 * 
	 * @param msg
	 */
	private static void receiveBroadcast(UserMessage msg) {
		String add;
		if (msg.getType().equals(MessageType.GUIDED)) {
			add = "(For your eyes only)";
		} else {
			add = "(Broadcasted)";
		}
		LOG.log(Level.FINE, "User message received " + add + " from preprocessor: " + msg);
		NotifierReceivedMessage.getInstance().notify(msg);
		RepositoryConfiguration.getService().logMessage(msg);
		UsecaseFactory.getSendMessageUsecase(new ACKMessage(CodeGenerator.getMyCode(), msg.getCode())).run();
	}

	/**
	 * Sends the keepalive message from the preprocessor to the domain It sends an ACK automatically
	 * 
	 * @param msg
	 */
	private static void receiveKeepAlive(KeepAliveMessage msg) {
		LOG.log(Level.FINE, "KeepAlive message received from preprocessor: " + msg);
		KeepAliveConfiguration.receiveKeepAlive(msg);
	}

	/**
	 * Sends the ack message from the preprocessor to the domain If response to our last keepalive updates the userlist
	 * If on sended messages cache updates the message from the response to "Arrived"
	 * 
	 * @param msg
	 */
	private static void receiveACK(ACKMessage msg) {
		LOG.log(Level.FINE, "ACK message received from preprocessor: " + msg);
		MessageCache.getCache().updateMessage(msg.getCodeResponse(), MessageStatus.ARRIVED);
	}
}
