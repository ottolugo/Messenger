package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.ObservableUserMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public interface MessageService {
	public void start();
	/**
	 * Sends a message from the GUI to the P2P
	 * 
	 * @param msg
	 */
	public void sendMessage(ObservableUserMessage msg);
	
	public void msgSubscribe(GUIObserver<UserMessage> obs);
	
	public void listSubscribe(GUIObserver<List<String>> obs);
	
	public String whoami();
}
