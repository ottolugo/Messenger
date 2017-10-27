package oesia.formacion.messenger.P2P.domain.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.ObservableUserMessage;
import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

public class MessageCache {
	private static MessageCache single;
	
	//Pattern singleton
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
				//Borra el mensaje del listener si ha llegado o está cancelado
				if(status.equals(MessageStatus.ARRIVED)){
					messages.remove(code);
				}
			}
		}
	}
	
	/**
	 * Checks all messages, updates to canceled all that expired and then
	 * Eliminates all canceled messages from the cache
	 */
	public void checkMessages(){
		ArrayList<Code> toErase = new ArrayList<Code>();
		for(Map.Entry<Code, ObservableUserMessage> entry : messages.entrySet()) {
		    Code key = entry.getKey();
		    ObservableUserMessage value = entry.getValue();
		    if(!DateUtil.isDateValid(value.getMessage().getCode().getDate())){
		    	updateMessage(key, MessageStatus.CANCELED);
		    	toErase.add(key);
		    }
		}
		for (Code code : toErase) {
			messages.remove(code);
		}

	}
}
