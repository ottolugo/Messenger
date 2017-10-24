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

	public DataConfiguration() {
	}

	public static String getWhoIam() {
		return whoIam;
	}

	public static void setWhoIam(String whoIam) {
		DataConfiguration.whoIam = whoIam;
	}

	public static Integer getKalTime() {
		return kalTime;
	}

	public static void setKalTime(Integer kalTime) {
		DataConfiguration.kalTime = kalTime;
	}

	public static Integer getAckTimeout() {
		return ackTimeout;
	}

	public static void setAckTimeout(Integer ackTimeout) {
		DataConfiguration.ackTimeout = ackTimeout;
	}
	
	public static Integer getPort() {
		return port;
	}

	public static void setPort(Integer port) {
		DataConfiguration.port = port;
	}

	public static String getDir() {
		return dir;
	}

	public static void setDir(String dir) {
		DataConfiguration.dir = dir;
	}

	public static void setDataConfiguration() throws IOException {
		final Properties properties = new Properties();
		final InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("config/application.properties");
		properties.load(propertiesStream);
		
		properties.setProperty("Whoami", System.getProperty("user.name")); 
		whoIam = String.valueOf(properties.get("Whoami"));
		properties.setProperty("KeepAliveTimeout", "10");
		kalTime = Integer.parseInt((String) properties.get("KeepAliveTimeout"));
		properties.setProperty("MessageTimeout", "5");
		ackTimeout = Integer.parseInt((String) properties.get("MessageTimeout"));
		properties.setProperty("port", "1496");
		port = Integer.parseInt((String) properties.get("port"));
		
		properties.setProperty("dir", System.getProperty("user.home")); 
		dir = String.valueOf(properties.get("dir"));
		propertiesStream.close();
	}

//	public static void loadDataConfiguration() throws IOException {
//		final Properties properties = new Properties();
//		final InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("config/application.properties");
//		properties.load(propertiesStream);
//		whoIam = String.valueOf(properties.getProperty("Whoami"));
//		kalTime = Integer.parseInt(properties.getProperty("KeepAliveTimeout"));
//		ackTimeout = Integer.parseInt(properties.getProperty("MessageTimeout"));
//		port = Integer.parseInt(properties.getProperty("port"));
//		
//		String nameDir = System.getProperty("java.class.path");
//		dir = String.valueOf(properties.setProperty(properties.getProperty("dir"), nameDir));
//		propertiesStream.close();
//	}
	
}
