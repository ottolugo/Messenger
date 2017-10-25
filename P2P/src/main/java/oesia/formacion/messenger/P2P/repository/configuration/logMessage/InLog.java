package oesia.formacion.messenger.P2P.repository.configuration.logMessage;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;

public class InLog {

	private final static Logger logr = Logger.getLogger( Logger.GLOBAL_LOGGER_NAME );
	
	
	public InLog() {}
	
	public void setupLogger()
	{
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.SEVERE);
		logr.addHandler(ch);
		
		try {
			FileHandler fh = new FileHandler("src/repository/configuration/LogMessage/myLog.log", true);
			fh.setLevel(Level.FINE);
			logr.addHandler(fh);
		} catch (IOException e) {
			logr.log(Level.SEVERE, "File log not working."+ e);
		}
	}
	
	public void test(UserMessage msg)
	{
		logr.info(msg.toString());
	}
	
}
