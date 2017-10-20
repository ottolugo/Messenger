package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class SendBroadcastMessage implements Usecase<Void> {

	private UserMessage message = null;

	public SendBroadcastMessage(UserMessage msg) {
		message = msg;
	}

	@Override
	public Void run() {
		// TODO Auto-generated method stub
		// TODO Ocuparse de que quede reflajado que el mensage en nuestra lista de enviados
		// TODO Pedirle al socket que envie el mensage
		return null;
	}

}
