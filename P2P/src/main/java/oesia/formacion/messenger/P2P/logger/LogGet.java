package oesia.formacion.messenger.P2P.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LogGet {

	private LogGet() {
	}

	public static Logger getLogger(Class<?> callerClass) {
		Logger logConfigurated = Logger.getLogger(callerClass.getName());
		ConsoleHandler handler = new ConsoleHandler();
		// El nivel para los que se muestran por pantalla
		handler.setLevel(Level.WARNING);
		handler.setFormatter(new ConsoleLogFormatter());
		logConfigurated.addHandler(handler);
		try {
			// Se agrega un filehandler para guardar todos los logs
			FileHandler saveHandler = new FileHandler("../Logger.log", true);
			saveHandler.setFormatter(new XMLFormatter());
			saveHandler.setLevel(Level.ALL);
		} catch (SecurityException e) {
		} catch (IOException e) {
		}
		return logConfigurated;
	}
}
