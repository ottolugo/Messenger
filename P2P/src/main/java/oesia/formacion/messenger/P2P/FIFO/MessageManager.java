package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public abstract class MessageManager {
	private int limitTime;
	private String user;

	public MessageManager(int limitTime, String user) {
		this.limitTime = limitTime;
		this.user = user;

	}

	public abstract void manageMessage(Message message);

	public int getLimitTime() {
		return limitTime;
	}

	public String getUser() {
		return user;
	}

}
