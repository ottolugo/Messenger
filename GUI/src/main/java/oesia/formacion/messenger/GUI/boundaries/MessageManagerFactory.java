package oesia.formacion.messenger.GUI.boundaries;

public class MessageManagerFactory {

    MessageManager messageManager = null;

    private MessageManagerFactory() {
    }

    public MessageManager getMessageManager() {
	if (messageManager == null) {
	    messageManager = new MessageManager();
	}

	return messageManager;
    }

}
