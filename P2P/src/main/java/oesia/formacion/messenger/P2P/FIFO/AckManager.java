package oesia.formacion.messenger.P2P.FIFO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.ACKMessage;
import oesia.formacion.messenger.P2P.domain.managers.FIFOMessageManager;

public class AckManager extends MessageManager {
	private LocalDateTime date;
	private FIFOMessageManager manager;

	public AckManager(int limitTime, String user) {
		super(limitTime, user);
		this.date = LocalDateTime.now();
	}

	@Override
	public void manageMessage(Message message) {
		if (message.getCode().getDate().until(date, ChronoUnit.SECONDS) < this.getLimitTime()
				&& message.getCode().getUser().equals(this.getUser())) {
			manager.receiveACK((ACKMessage) message);
		}
	}

}
