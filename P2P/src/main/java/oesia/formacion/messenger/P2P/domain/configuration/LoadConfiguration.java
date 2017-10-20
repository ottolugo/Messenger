package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.keepAliver.KeepAliverConfiguration;

public class LoadConfiguration {

<<<<<<< HEAD
	public void start() {
=======
	public static void start(){
>>>>>>> branch 'master' of https://github.com/ottolugo/Messenger
		LocalConfiguration config = RepositoryConfiguration.getService().getConfiguration();
		PreprocessorConfiguration.getPreprocessorService().startService();
		SocketConfiguration.getService().startService(config.getPort());
		KeepAliverConfiguration.getKeepAliverService().startService();
	}

}
