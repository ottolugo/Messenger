package oesia.formacion.messenger.P2P.domain.entities;

public class LocalConfiguration {
	String whoami;
	int KeepAliveTimeout;
	int MessageTimeout;
	int port;

	public LocalConfiguration(String whoami, int keepAliveTimeout, int messageTimeout, int port) {
		super();
		this.whoami = whoami;
		KeepAliveTimeout = keepAliveTimeout;
		MessageTimeout = messageTimeout;
		this.port = port;
	}

	public String getWhoami() {
		return whoami;
	}

	public void setWhoami(String whoami) {
		this.whoami = whoami;
	}

	public int getKeepAliveTimeout() {
		return KeepAliveTimeout;
	}

	public void setKeepAliveTimeout(int keepAliveTimeout) {
		KeepAliveTimeout = keepAliveTimeout;
	}

	public int getMessageTimeout() {
		return MessageTimeout;
	}

	public void setMessageTimeout(int messageTimeout) {
		MessageTimeout = messageTimeout;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + KeepAliveTimeout;
		result = prime * result + MessageTimeout;
		result = prime * result + port;
		result = prime * result + ((whoami == null) ? 0 : whoami.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalConfiguration other = (LocalConfiguration) obj;
		if (KeepAliveTimeout != other.KeepAliveTimeout)
			return false;
		if (MessageTimeout != other.MessageTimeout)
			return false;
		if (port != other.port)
			return false;
		if (whoami == null) {
			if (other.whoami != null)
				return false;
		} else if (!whoami.equals(other.whoami))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocalConfiguration [whoami=" + whoami + ", KeepAliveTimeout=" + KeepAliveTimeout + ", MessageTimeout="
				+ MessageTimeout + ", port=" + port + "]";
	}
}
