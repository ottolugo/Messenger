package oesia.formacion.messenger.P2P.FIFO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public abstract class MessageManager {
	/**
	 * abstract class that rules the structure of the message managers
	 */
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

	public boolean isValid(Message message) {
		LocalDateTime date = LocalDateTime.now();
		if (message.getCode().getDate().until(date, ChronoUnit.SECONDS) < limitTime
				&& message.getCode().getUser().equals(user)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDateValid(Message message) {
		LocalDateTime date = LocalDateTime.now();
		if (message.getCode().getDate().until(date, ChronoUnit.SECONDS) < limitTime) {
			return true;
		} else {
			return false;
		}
	}

}
