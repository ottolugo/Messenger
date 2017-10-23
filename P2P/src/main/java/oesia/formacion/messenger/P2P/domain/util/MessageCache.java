package oesia.formacion.messenger.P2P.domain.util;

import java.util.HashMap;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.ObservableUserMessage;

public class MessageCache {
	private HashMap<Code, ObservableUserMessage> messages;

	public MessageCache() {
		messages = new HashMap<Code, ObservableUserMessage>();
	}

	public void addMessage(ObservableUserMessage msg) {
		messages.put(msg.getMessage().getCode(), msg);
	}

	public void updateMessage(Code code, MessageStatus status) {
		ObservableUserMessage msg = messages.get(code);
		if (msg != null) {
			if(!msg.getMessage().getStatus().equals(status)){
				msg.setStatus(status);
			}
		}
	}
}
