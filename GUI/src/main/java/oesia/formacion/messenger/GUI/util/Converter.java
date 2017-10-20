package oesia.formacion.messenger.GUI.util;

import oesia.formacion.messenger.GUI.entities.MessageGui;
import oesia.formacion.messenger.GUI.entities.MessageStatusGui;
import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.GuidedMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.MessageStatus;

public class Converter {

    public static UserMessage convertIntoMessage(MessageGui message) {
	UserMessage returnValue;
	Code code = new Code(message.getSender(), message.getMessageTime());
	if (message.isBroadcastedMessage()) {
	    returnValue = new UserMessage(code, message.getMessage());
	} else {
	    returnValue = new GuidedMessage(code, message.getMessage(), message.getReceiver());
	}
	return returnValue;
    }

    public static MessageGui convertIntoMessage(UserMessage message) {
	MessageGui returnValue = null;
	switch (message.getType()) {
	    case GUIDED:
		GuidedMessage gm = (GuidedMessage) message;
		returnValue = new MessageGui(gm.getContenido(), gm.getCode().getUser(), gm.getUserDestinity(),
			convertIntoMessageStatus(gm.getStatus()), gm.getCode().getDate());
		break;
	    case BROADCAST:
		returnValue = new MessageGui(message.getContenido(), message.getCode().getUser(),
			convertIntoMessageStatus(message.getStatus()), message.getCode().getDate());
		break;
	    default:
		break;
	}

	return returnValue;
    }

    private static MessageStatusGui convertIntoMessageStatus(MessageStatus state) {
	MessageStatusGui returnValue;
	switch (state) {
	    case SENT:
		returnValue = MessageStatusGui.SENT;
		break;
	    case ARRIVED:
		returnValue = MessageStatusGui.ARRIVED;
		break;
	    case CANCELED:
		returnValue = MessageStatusGui.CANCELED;
		break;
	    default:
		returnValue = MessageStatusGui.NEW;
		break;
	}
	return returnValue;
    }

}
