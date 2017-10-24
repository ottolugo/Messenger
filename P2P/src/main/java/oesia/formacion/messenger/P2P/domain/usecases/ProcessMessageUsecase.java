package oesia.formacion.messenger.P2P.domain.usecases;

import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.managers.PreprocessorMessageManager;
import oesia.formacion.messenger.P2P.logger.LogGet;

public class ProcessMessageUsecase implements Usecase<Void> {
	private static final Logger LOG = LogGet.getLogger(ProcessMessageUsecase.class);
	private Message message;

	public ProcessMessageUsecase(Message message) {
		this.message = message;
	}

	@Override
	public Void run() {
		if (message instanceof ACKMessage) {
			ACKMessage recieved = (ACKMessage) message;
			PreprocessorMessageManager.receiveACK(recieved);
		} else if (message instanceof KeepAliveMessage) {
			KeepAliveMessage recieved = (KeepAliveMessage) message;
			PreprocessorMessageManager.receiveKeepAlive(recieved);
		} else if (message instanceof UserMessage) {
			UserMessage recieved = (UserMessage) message;
			PreprocessorMessageManager.receiveBroadcast(recieved);
		} else {
			LOG.warning("Llego algo equivocado al caso de uso de procesar mensage");
		}
		return null;
	}

}
