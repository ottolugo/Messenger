package oesia.formacion.messenger.P2P.logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * Clase estatica que te da un log
 * 
 * @author ramunoz
 *
 */
public class LogGet {

	private static Map<Class<?>, Logger> logMap = null;

	private LogGet() {
	}

	/**
	 * Crea el loger aplicandole los diferentes manejadores para poder usarse
	 * 
	 * @param callerClass clase que llama al logger
	 * @return un loger configurado
	 */
	public static Logger getLogger(Class<?> callerClass) {
		Logger log = null;
		if (logMap == null) {
			logMap = new HashMap<Class<?>, Logger>();
		}
		log = logMap.containsKey(callerClass) ? logMap.get(callerClass) : createLog(callerClass);
		return log;
	}

	private static Logger createLog(Class<?> callerClass) {
		Logger logConfigurated = Logger.getLogger(callerClass.getName());
		ConsoleHandler handler = new ConsoleHandler();
		// El nivel para los que se muestran por pantalla
		handler.setLevel(Level.WARNING);
		handler.setFormatter(new ConsoleLogFormatter());
		logConfigurated.addHandler(handler);
		try {
			// Se agrega un filehandler para guardar todos los logs
			FileHandler saveHandler = new FileHandler("../Logger.log", false);
			saveHandler.setLevel(Level.ALL);
			saveHandler.setFormatter(new XMLFormatter());
			logConfigurated.addHandler(saveHandler);

		} catch (SecurityException e) {
		} catch (IOException e) {
		}
		logMap.put(callerClass, logConfigurated);
		return logConfigurated;
	}
}
