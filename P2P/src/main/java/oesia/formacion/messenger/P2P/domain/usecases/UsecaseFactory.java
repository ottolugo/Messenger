package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public class UsecaseFactory {
	public static Usecase getSendMessageUsecase(Message msg) {
		return new SendMessageUsecase(msg);
	}

	public static Usecase getProcessMessageUsecase(Message msg) {
		return new ProcessMessageUsecase(msg);
	}

	public static Usecase getReceiveMessageUsecase(Message msg) {
		return new ReceiveMessageUsecase(msg);
	}

	public static Usecase getConfirmSentUsecase(Message msg) {
		return new ConfirmSentUsecase(msg);
	}
}
