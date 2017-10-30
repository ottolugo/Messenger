package oesia.formacion.messenger.P2P.repository.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataConfiguration {

	private String whoIam;
	private Integer kalTime;
	private Integer ackTimeout;
	private Integer port;
	private String dir;
	
	private static DataConfiguration dataSingle;

	public static DataConfiguration getDataConfiguration() {
		if(dataSingle == null)
		{
			dataSingle = new DataConfiguration();
		}
		return dataSingle;
	}

	private DataConfiguration() {

		File fileExist = new File("application.properties");
		if(!fileExist.exists())
		{
			Properties prop = new Properties();

			try {
				prop.setProperty("Whoami", System.getProperty("user.name"));
				prop.setProperty("Dir", System.getProperty("user.home"));
				prop.setProperty("KeepAliveTimeout", "10");
				prop.setProperty("MessageTimeout", "5");
				prop.setProperty("Port", "1497");
				FileOutputStream fileOut = new FileOutputStream(fileExist);
				prop.store(fileOut, "Data Configuration");
				fileOut.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
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
