package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class LoadConfiguration {

	public static void start(){
		RepositoryConfiguration.getService().loadConfiguration();
		PreprocessorConfiguration.getPreprocessorService().startService();
		SocketConfiguration.getService().startService(LocalConfiguration.getPort());
		KeepAliverConfiguration.startKeepAliver();
		CancelerConfiguration.startCanceler();
	}

}
