package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class LoadConfiguration {

	public static void start(){
		LocalConfiguration config = RepositoryConfiguration.getService().getConfiguration();
		Configuration.setConfiguration(config);
		PreprocessorConfiguration.getPreprocessorService().startService();
		SocketConfiguration.getService().startService(config.getPort());
		KeepAliverConfiguration.startKeepAliver();
		CancelerConfiguration.startCanceler();
	}

}
