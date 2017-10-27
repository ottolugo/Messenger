package oesia.formacion.messenger.P2P.domain.entities;

public class LocalConfiguration {
	private static String whoami;
	private static int keepAliveTimeout;
	private static int messageTimeout;
	private static int port;
	
	private LocalConfiguration(){
	}

	public static void loadConfiguration(String whoamiN, int keepAliveTimeoutN, int messageTimeoutN, int portN) {
		whoami = whoamiN;
		keepAliveTimeout = keepAliveTimeoutN;
		messageTimeout = messageTimeoutN;
		port = portN;
	}

	public static String getWhoami() {
		return whoami;
	}

	public static int getKeepAliveTimeout() {
		return keepAliveTimeout;
	}

	public static int getMessageTimeout() {
		return messageTimeout;
	}

	public static int getPort() {
		return port;
	}
}
