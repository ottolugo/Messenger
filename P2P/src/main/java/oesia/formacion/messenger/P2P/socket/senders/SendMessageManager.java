package oesia.formacion.messenger.P2P.socket.senders;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.socket.thread.SocketThreadManager;

public class SendMessageManager {

	private SendMessageManager() {
	}

	/**
	 * Se ocupa de preparar el hilo para mandar el mensage
	 * 
	 * @param msg
	 */
	public static void sendMessage(Message msg) {
		// Se prepara la tarea y se agrega a la lista de tareas
		SocketThreadManager.checkSender();
		SendMessageRunable runableToStart = null;
		runableToStart = new SendMessageRunable(msg);
		SendMessageFIFO.getInstance().addWork(runableToStart);
	}

}
