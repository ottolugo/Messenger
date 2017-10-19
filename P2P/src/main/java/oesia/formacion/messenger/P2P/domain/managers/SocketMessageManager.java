package oesia.formacion.messenger.P2P.domain.managers;

import oesia.formacion.messenger.P2P.domain.entities.Message;

/**
 * This class is used by the socket to send messages to the domain
 * @author EXTamarino
 *
 */
public class SocketMessageManager {
	/**
	 * Sends the message from the socket to the domain, and then from the domain to the FIFO
	 * @param msg
	 */
	public static void receiveMessage(Message msg){
		//TODO recibir mensaje y pasar a FIFO
	}
}
