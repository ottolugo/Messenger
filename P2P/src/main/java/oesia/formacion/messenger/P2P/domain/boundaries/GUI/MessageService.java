package oesia.formacion.messenger.P2P.domain.boundaries.GUI;

import java.util.List;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public interface MessageService {
	/**
	 * Sends a message from the GUI to the P2P
	 * 
	 * @param msg
	 */
	public void sendMessage(UserMessage msg);
	
	public void msgSubscribe(GUIObserver<UserMessage> obs);
	
	public void listSubscribe(GUIObserver<List<String>> obs);
	
	public String whoami();
}
