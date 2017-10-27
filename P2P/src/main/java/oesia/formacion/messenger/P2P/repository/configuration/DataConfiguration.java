package oesia.formacion.messenger.P2P.repository.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataConfiguration {

	private static String whoIam;
	private static Integer kalTime;
	private static Integer ackTimeout;
	private static Integer port;
	private static String dir;

	private DataConfiguration() {
	}

	public static String getWhoIam() {
		return whoIam;
	}

	public static Integer getKalTime() {
		return kalTime;
	}

	public static Integer getAckTimeout() {
		return ackTimeout;
	}

	public static Integer getPort() {
		return port;
	}

	public static String getDir() {
		return dir;
	}

	public static void setDataConfiguration() throws IOException {
		final Properties properties = new Properties();
		final InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("config/application.properties");
		properties.load(propertiesStream);

		properties.setProperty("Whoami", System.getProperty("user.name"));
		whoIam = String.valueOf(properties.get("Whoami"));
		
		kalTime = Integer.parseInt((String) properties.get("KeepAliveTimeout"));
		ackTimeout = Integer.parseInt((String) properties.get("MessageTimeout"));
		port = Integer.parseInt((String) properties.get("port"));

		properties.setProperty("dir", System.getProperty("user.home"));
		dir = String.valueOf(properties.get("dir"));
		propertiesStream.close();
	}

}
