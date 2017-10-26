package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.util.MessageCache;

/**
 * Clase que se dedica a mandar mensages y guardar en el los los Usermensages
 * 
 * @author ramunoz
 *
 */
public class ConfirmSentUsecase implements Usecase {

	private Message message;

	/**
	 * se le entrega el mensage que se va a enviar
	 * 
	 * @param message mensage a enviar
	 */
	public ConfirmSentUsecase(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		MessageCache.getCache().updateMessage(message.getCode(), MessageStatus.SENT);
	}

}
