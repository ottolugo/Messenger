package oesia.formacion.messenger.P2P.preprocessor.messageManagers.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.preprocessor.preprocessorThreadCheck.MessageCheck;
import oesia.formacion.messenger.P2P.socket.reciever.MessagePortListener;

/**
 * Singleton factory that initiates the thread
 */
public class MessageManagerConfiguration {

    private static final Logger LOG = Logger.getLogger(MessagePortListener.class.getName());
    private static MessageCheck messageManager = null;

    public static MessageCheck startMessageManager() {
	if (messageManager == null) {
	    messageManager = new MessageCheck();
	    messageManager.start();
	    LOG.log(Level.INFO, "Thread created and running");
	}
	return messageManager;
    }

}
