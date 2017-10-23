package oesia.formacion.messenger.P2P.domain.managers;

import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.configuration.CacheConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.KeepAliveConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.notifiers.NotifierReceivedMessage;
import oesia.formacion.messenger.P2P.domain.util.CodeGenerator;
import oesia.formacion.messenger.P2P.logger.LogGet;

/**
 * This class is used by the FIFO to send messages to the domain
 * 
 * @author EXTamarino
 *
 */
public class PreprocessorMessageManager {
	private static final Logger LOG = LogGet.getLogger(PreprocessorMessageManager.class);
	/**
	 * Sends the broadcast message from the preprocessor to the domain It sends the broadcasted message to the gui
	 * 
	 * @param msg
	 */
	public static void receiveBroadcast(UserMessage msg) {
		LOG.log(Level.FINE, "Broadcast message received from preprocessor: " + msg);
		NotifierReceivedMessage.getInstance().notify(msg);
		SocketConfiguration.getService().sendMessage(new ACKMessage(CodeGenerator.getMyCode(), msg.getCode()));
	}

	/**
	 * Sends the keepalive message from the preprocessor to the domain It sends an ACK automatically
	 * 
	 * @param msg
	 */
	public static void receiveKeepAlive(KeepAliveMessage msg) {
		LOG.log(Level.FINE, "KeepAlive message received from preprocessor: " + msg);
		KeepAliveConfiguration.receiveKeepAlive(msg);
	}

	/**
	 * Sends the ack message from the preprocessor to the domain If response to our last keepalive updates the userlist
	 * If on sended messages cache updates the message from the response to "Arrived"
	 * 
	 * @param msg
	 */
	public static void receiveACK(ACKMessage msg) {
		LOG.log(Level.FINE, "ACK message received from preprocessor: " + msg);
		CacheConfiguration.getMessageCache().updateMessage(msg.getCodeResponse(), MessageStatus.ARRIVED);
	}
}
