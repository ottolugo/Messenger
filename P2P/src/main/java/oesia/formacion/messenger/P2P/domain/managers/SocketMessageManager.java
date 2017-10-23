package oesia.formacion.messenger.P2P.domain.managers;

import oesia.formacion.messenger.P2P.domain.configuration.PreprocessorConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.util.MessageCache;

/**
 * This class is used by the socket to send messages to the domain
 * 
 * @author EXTamarino
 *
 */
public class SocketMessageManager {
	/**
	 * Sends the message from the socket to the domain, and then from the domain to the FIFO
	 * 
	 * @param msg
	 */
	public static void receiveMessage(Message msg) {
		PreprocessorConfiguration.getPreprocessorService().put(msg);
	}
	/**
	 * Executed when the message is sent
	 * @param msg
	 */
	public static void sentMessage(Code code) {
		MessageCache.getCache().updateMessage(code, MessageStatus.SENT);
	}
}
