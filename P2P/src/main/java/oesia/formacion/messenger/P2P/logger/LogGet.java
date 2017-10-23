package oesia.formacion.messenger.P2P.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class LogGet {

	private LogGet() {
	}

	public static Logger getLogger(Class<?> callerClass) {
		Logger logConfigurated = Logger.getLogger(callerClass.getName());
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new ConsoleLogFormatter());
		logConfigurated.addHandler(handler);
		return logConfigurated;
	}
}
