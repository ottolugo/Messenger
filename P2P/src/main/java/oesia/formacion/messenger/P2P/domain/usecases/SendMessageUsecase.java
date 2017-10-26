package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.configuration.RepositoryConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.MessageType;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

/**
 * Clase que se dedica a mandar mensages y guardar en el los los Usermensages
 * 
 * @author ramunoz
 *
 */
public class SendMessageUsecase implements Usecase {

	private Message message;

	/**
	 * se le entrega el mensage que se va a enviar
	 * 
	 * @param message mensage a enviar
	 */
	public SendMessageUsecase(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		SocketConfiguration.getService().sendMessage(message);
		if (message.getType().equals(MessageType.GUIDED) || message.getType().equals(MessageType.BROADCAST)) {
			RepositoryConfiguration.getService().logMessage((UserMessage) message);
		}
	}

}
