package oesia.formacion.messenger.GUI.boundaries;

import oesia.formacion.messenger.GUI.entities.MessageGui;
import oesia.formacion.messenger.GUI.util.Converter;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageObserver;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

public class MessageObserverImpl implements MessageObserver {

    private MessageGui msg;

    MessageObserverImpl(MessageGui msg) {
	this.msg = msg;
    }

    public void update(MessageStatus status) {
	msg.setStatus(Converter.convertIntoMessageStatus(status));

    }

}
