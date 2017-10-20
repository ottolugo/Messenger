package oesia.formacion.messenger.GUI.boundaries;

import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class GUIObserverMessageImpl implements GUIObserver<UserMessage> {

    public void update(UserMessage obj) {
	// TODO Auto-generated method stub
    	System.out.println("Mensaje recibido:" + obj);
    }

}
