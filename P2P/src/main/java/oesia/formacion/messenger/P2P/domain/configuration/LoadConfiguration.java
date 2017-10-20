package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class LoadConfiguration {

	public void start(){
		LocalConfiguration config = RepositoryConfiguration.getService().getConfiguration();
		PreprocessorConfiguration.getPreprocessorService().startService();
		SocketConfiguration.getService().startService(config.getPort());
	}
	
}