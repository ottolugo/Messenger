package oesia.formacion.messenger.P2P.domain.util;

import java.util.HashMap;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

public class MessageCache {
	private HashMap<Code, BroadcastMessage> messages;

	MessageCache() {
		messages = new HashMap<Code, BroadcastMessage>();
	}

	public void addMessage(BroadcastMessage msg) {
		messages.put(msg.getCode(), msg);
	}

	public void updateMessage(Code code, MessageStatus status) {
		BroadcastMessage msg = messages.get(code);
		msg.setStatus(status);
		msg.allNotify();
	}
}
