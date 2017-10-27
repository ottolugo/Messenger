package oesia.formacion.messenger.P2P.preprocessor.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.preprocessor.preprocessor.MessagePreprocessor;
import oesia.formacion.messenger.P2P.socket.reciever.MessagePortListener;

/**
 * Singleton factory that initiates the thread
 */
public class MessagePreprocessorConfiguration {

	private static final Logger LOG = Logger.getLogger(MessagePortListener.class.getName());
	private static MessagePreprocessor messageManager = null;

	public static void startMessagePreprocessor() {
		if (messageManager == null) {
			messageManager = new MessagePreprocessor();
			messageManager.start();
			LOG.log(Level.INFO, "Preprocessor thread created and running");
		}
	}

}
