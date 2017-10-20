package oesia.formacion.messenger.P2P.preprocessor.messageManagers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import oesia.formacion.messenger.P2P.domain.entities.Message;

/**
 * abstract class that rules the structure of the message managers
 */
public abstract class MessageManager {

	private int limitTime;
	private String user;

	public MessageManager(int limitTime, String user) {
		this.limitTime = limitTime;
		this.user = user;

	}

	/**
	 * send the message to the right fifoManager
	 * 
	 * @param message
	 */
	public abstract void manageMessage(Message message);

	public int getLimitTime() {
		return limitTime;
	}

	public String getUser() {
		return user;
	}

	/**
	 * check if the message is good to go
	 * 
	 * @param message
	 * @return
	 */
	public boolean itIsNotMe(Message message) {
		if (message.getCode().getUser().equals(user)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * check if the message is good to go
	 * 
	 * @param message
	 * @return
	 */
	public boolean isDateValid(Message message) {
		LocalDateTime date = LocalDateTime.now();
		if (message.getCode().getDate().until(date, ChronoUnit.SECONDS) < limitTime) {
			return true;
		} else {
			return false;
		}
	}

}
