package oesia.formacion.messenger.P2P.domain.util;

import java.util.HashMap;
import java.util.Map;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.ObservableUserMessage;

public class MessageCache {
	private static MessageCache single;
	
	public static MessageCache getCache(){
		if(single == null){
			single = new MessageCache();
		}
		return single;
	}
	
	private HashMap<Code, ObservableUserMessage> messages;

	private MessageCache() {
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
				//Borra el mensaje del listener si ha llegado o está cacelado
				if(status.equals(MessageStatus.ARRIVED) || status.equals(MessageStatus.CANCELED)){
					messages.remove(code);
				}
			}
		}
	}
	
	public void checkMessages(){
		for(Map.Entry<Code, ObservableUserMessage> entry : messages.entrySet()) {
		    Code key = entry.getKey();
		    ObservableUserMessage value = entry.getValue();
		    if(!DateUtil.isDateValid(value.getMessage())){
		    	updateMessage(key, MessageStatus.CANCELED);
		    }
		}

	}
}
