package oesia.formacion.messenger.GUI;

import oesia.formacion.messenger.GUI.boundaries.GUIObserverMessageImpl;
import oesia.formacion.messenger.GUI.boundaries.GUIObserverUserListImpl;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageFactory;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;

public class Launch {
	public static void start() {
		MessageService srv = MessageFactory.getMessageService();
		srv.start();
		srv.msgSubscribe(new GUIObserverMessageImpl());
		srv.listSubscribe(new GUIObserverUserListImpl());
		Refresher r = new Refresher();
		r.start();
	}
}
