package oesia.formacion.messenger.GUI.boundaries;

public class MessageManagerFactory {

    private static MessageManager messageManager = null;

    private MessageManagerFactory() {
    }

    public static MessageManager getMessageManager() {
	if (messageManager == null) {
	    messageManager = new MessageManager();
	}

	return messageManager;
    }

}
