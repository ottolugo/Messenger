package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.managers.PreprocessorMessageManager;

public class ProcessMessageUsecase implements Usecase {
	private Message message;

	public ProcessMessageUsecase(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		PreprocessorMessageManager.receiveMessage(message);
	}

}
