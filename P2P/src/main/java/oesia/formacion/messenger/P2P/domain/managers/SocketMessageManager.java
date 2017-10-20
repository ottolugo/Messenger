package oesia.formacion.messenger.P2P.domain.managers;

import oesia.formacion.messenger.P2P.domain.configuration.CacheConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.PreprocessorConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

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
		System.out.println("Message received, passing to Preprocessor: " + msg);
		PreprocessorConfiguration.getPreprocessorService().put(msg);
	}
	/**
	 * Executed when the message is sent
	 * @param msg
	 */
	public static void sentMessage(Code code) {
		System.out.println("Message sent updating status on cache: " + code);
		CacheConfiguration.getMessageCache().updateMessage(code, MessageStatus.SENT);
	}
}
