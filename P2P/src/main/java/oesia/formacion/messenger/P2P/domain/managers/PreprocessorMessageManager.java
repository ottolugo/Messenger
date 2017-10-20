package oesia.formacion.messenger.P2P.domain.managers;

import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

/**
 * This class is used by the FIFO to send messages to the domain
 * 
 * @author EXTamarino
 *
 */
public class PreprocessorMessageManager {
	/**
	 * Sends the broadcast message from the fifo to the domain
	 * 
	 * @param msg
	 */
	public static void receiveBroadcast(UserMessage msg) {
		// TODO gestionar
	}

	/**
	 * Sends the broadcast message from the fifo to the domain
	 * 
	 * @param msg
	 */
	public static void receiveKeepAlive(KeepAliveMessage msg) {
		// TODO gestionar
	}

	/**
	 * Sends the broadcast message from the fifo to the domain
	 * 
	 * @param msg
	 */
	public static void receiveACK(ACKMessage msg) {
		// TODO gestionar
	}
}