package oesia.formacion.messenger.GUI.boundaries;

import oesia.formacion.messenger.GUI.App;
import oesia.formacion.messenger.GUI.util.Converter;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.GUIObserver;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class GUIObserverMessageImpl implements GUIObserver<UserMessage> {

	public void update(UserMessage obj) {
		App.getApp().addMessage(Converter.convertIntoMessage(obj));
	}

}
