package oesia.formacion.messenger.P2P.domain.util;

import java.util.HashMap;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

public class MessageCache {
	private HashMap<Code, UserMessage> messages;

	public MessageCache() {
		messages = new HashMap<Code, UserMessage>();
	}

	public void addMessage(UserMessage msg) {
		messages.put(msg.getCode(), msg);
	}

	public void updateMessage(Code code, MessageStatus status) {
		UserMessage msg = messages.get(code);
		if (msg != null) {
			msg.setStatus(status);
		}
	}
}
