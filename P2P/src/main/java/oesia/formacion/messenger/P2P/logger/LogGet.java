package oesia.formacion.messenger.P2P.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
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
	private static FileHandler saveHandler = null;
	private static ConsoleHandler handler = null;

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
			try {
				// Se necesita leer el fichero de resource como stream de datos para poder pasarlo
				InputStream inputFile = LogGet.class.getResourceAsStream("log.properties");
				// Se crea el fichero temporal
				File tempfile = File.createTempFile(String.valueOf(inputFile.toString()), ".tmp");
				tempfile.deleteOnExit();
				// Se asocia el fichero al outputFStream para modificar los datos
				FileOutputStream outputFileStream = new FileOutputStream(tempfile);
				byte[] bufferRead = new byte[1024];
				int bytesRead;
				// Se leen los datos
				while ((bytesRead = inputFile.read(bufferRead)) != -1) {
					outputFileStream.write(bufferRead, 0, bytesRead);
				}
				outputFileStream.close();

				// Se leen las propiedades en el fichero temporal de Logger
				FileInputStream logProperties;
				logProperties = new FileInputStream(tempfile);
				LogManager.getLogManager().readConfiguration(logProperties);
			} catch (SecurityException | IOException e) {
				e.printStackTrace();
			}
		}
		log = logMap.containsKey(callerClass) ? logMap.get(callerClass) : createLog(callerClass);
		return log;
	}

	private static Logger createLog(Class<?> callerClass) {
		Logger logConfigurated = Logger.getLogger(callerClass.getName());
		logConfigurated.addHandler(getConsoleHandler());
		logConfigurated.addHandler(getFileHandler());
		logMap.put(callerClass, logConfigurated);
		return logConfigurated;
	}

	private static ConsoleHandler getConsoleHandler() {
		if (handler == null) {
			handler = new ConsoleHandler();
			// El nivel para los que se muestran por pantalla
			handler.setLevel(Level.WARNING);
			handler.setFormatter(new ConsoleLogFormatter());
		}
		return handler;
	}

	private static FileHandler getFileHandler() {
		if (saveHandler == null) {
			try {
				// Se agrega un filehandler para guardar todos los logs
				saveHandler = new FileHandler("application.log", false);
				saveHandler.setLevel(Level.ALL);
				saveHandler.setFormatter(new XMLFormatter());
			} catch (SecurityException e) {
			} catch (IOException e) {
			}
		}
		return saveHandler;

	}
}
