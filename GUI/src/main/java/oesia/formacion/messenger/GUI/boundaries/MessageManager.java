package oesia.formacion.messenger.GUI.boundaries;

import oesia.formacion.messenger.GUI.entities.MessageGui;
import oesia.formacion.messenger.GUI.util.Converter;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageFactory;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageObserver;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class MessageManager {
    MessageService serviceMessage = null;

    public MessageManager() {
	serviceMessage = MessageFactory.getMessageService();
    }

    public void sendMessage(MessageGui message) {
	UserMessage um = Converter.convertIntoMessage(message);
	MessageObserver mo = new MessageObserverImpl(message);
	um.addObserver(mo);
	serviceMessage.sendMessage(um);
    }

    public String whoIAm() {
	return serviceMessage.whoami();
    }

}
