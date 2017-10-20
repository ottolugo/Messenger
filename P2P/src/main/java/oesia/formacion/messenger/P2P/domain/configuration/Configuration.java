package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class Configuration {
	private static LocalConfiguration config;

	public static LocalConfiguration getConfiguration() {
		return config;
	}

	public static void setConfiguration(LocalConfiguration loadedConfig) {
		config = loadedConfig;
	}
}