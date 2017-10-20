package oesia.formacion.messenger.P2P.domain.managers;

import java.time.LocalDateTime;

import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Code;
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
		SocketConfiguration.getService().sendMessage(new ACKMessage(getMyCode(), msg.getCode()));
	}

	/**
	 * Sends the broadcast message from the fifo to the domain
	 * 
	 * @param msg
	 */
	public static void receiveACK(ACKMessage msg) {
		// TODO gestionar
	}
	
	private static Code getMyCode(){
		return new Code(Configuration.getConfiguration().getWhoami(), LocalDateTime.now());
	}
}
