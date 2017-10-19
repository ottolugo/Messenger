package oesia.formacion.messenger.GUI.boundaries;

import javafx.collections.ObservableList;
import oesia.formacion.messenger.GUI.entities.MessageGui;
import oesia.formacion.messenger.GUI.util.Converter;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageFactory;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageService;

public class MessageManager {
    ObservableList<MessageGui> lol;
    MessageService serviceMessage = null;

    public MessageManager() {
	serviceMessage = MessageFactory.getMessageService();
    }

    public void sendMessage(MessageGui message) {

	serviceMessage.sendMessage(Converter.convertIntoMessage(message));
    }
}
