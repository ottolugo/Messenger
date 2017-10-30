package oesia.formacion.messenger.P2P.repository.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataConfiguration {

	private static String whoIam;
	private static Integer kalTime;
	private static Integer ackTimeout;
	private static Integer port;
	private static String dir;

	public DataConfiguration() {

		Properties prop = new Properties();
		File file = new File("application.properties");

		try {
			prop.setProperty("Whoami", System.getProperty("user.name"));
			prop.setProperty("Dir", System.getProperty("user.home"));
			prop.setProperty("KeepAliveTimeout", "10");
			prop.setProperty("MessageTimeout", "5");
			prop.setProperty("Port", "1497");
			FileOutputStream fileOut = new FileOutputStream(file);
			prop.store(fileOut, "Data Configuration");
			fileOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getWhoIam() {
		return whoIam;
	}

	public Integer getKalTime() {
		return kalTime;
	}

	public Integer getAckTimeout() {
		return ackTimeout;
	}

	public Integer getPort() {
		return port;
	}

	public String getDir() {
		return dir;
	}

	public void setDataConfiguration() throws IOException {
		final Properties properties = new Properties();
		properties.load(new FileReader("application.properties"));

		ackTimeout = Integer.parseInt((String) properties.get("MessageTimeout"));
		kalTime = Integer.parseInt((String) properties.get("KeepAliveTimeout"));
		whoIam = String.valueOf(properties.get("Whoami"));
		port = Integer.parseInt((String) properties.get("Port"));
		dir = String.valueOf(properties.get("Dir"));
	}

}
