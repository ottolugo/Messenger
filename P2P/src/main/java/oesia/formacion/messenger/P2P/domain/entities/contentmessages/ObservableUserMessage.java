package oesia.formacion.messenger.P2P.domain.entities.contentmessages;

import java.util.ArrayList;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageObserver;
import oesia.formacion.messenger.P2P.domain.entities.ObservableMessage;

public class ObservableUserMessage implements ObservableMessage {

	private ArrayList<MessageObserver> observers;
	UserMessage msg;
	
	public ObservableUserMessage(UserMessage msg){
		this.msg = msg;
		this.observers = new ArrayList<MessageObserver>();
	}
	
	public UserMessage getMessage(){
		return msg;
	}
	
	public void setStatus(MessageStatus status){
		msg.setStatus(status);
		allNotify();
	}

	@Override
	public void notify(MessageObserver obs) {
		if (observers.contains(obs)) {
			obs.update(msg.getStatus());
		}
	}

	@Override
	public void allNotify() {
		for (MessageObserver messageObserver : observers) {
			messageObserver.update(msg.getStatus());
		}
	}

	@Override
	public void addObserver(MessageObserver obs) {
		observers.add(obs);

	}

	@Override
	public void dropObserver(MessageObserver obs) {
		observers.remove(obs);
	}
}
