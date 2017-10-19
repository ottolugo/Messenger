package oesia.formacion.messenger.P2P.socket.senders;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.socket.thread.SocketThreadManager;

public class SendMessageManager {

	private SendMessageManager() {
	}

	/**
	 * Se ocupa de preparar el hilo para mander el mensage
	 * 
	 * @param msg
	 */
	public static void sendMessage(Message msg) {

		// Se prepara el thread, se lanza y se agrega a la lista de threads
		Thread sendMessageThread = null;
		SendMessageRunable runableToStart = null;
		runableToStart = new SendMessageRunable(msg);
		sendMessageThread = new Thread(runableToStart);

		sendMessageThread.start();
		SocketThreadManager.addSendMessageThread(sendMessageThread);
	}

}
