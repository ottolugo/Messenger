package oesia.formacion.messenger.P2P.repository.boundaries;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.repository.RepositoryFactory;
import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.manager.ManagerRepositoryServiceImpl;

public class RepositoryServiceImpl implements RepositoryService {

	private final Logger LOGMSG = Logger.getLogger(ManagerRepositoryServiceImpl.class.getName());
	private final ManagerRepositoryService managerRepositoryService;
	private final DataConfiguration dataConfiguration;

	public RepositoryServiceImpl() {
		FileHandler logFileHandler;
		try {
			logFileHandler = new FileHandler("../msg.log", true);
			logFileHandler.setFormatter(new SimpleFormatter());
			LOGMSG.addHandler(logFileHandler);
		} catch (SecurityException | IOException e1) {
		}
		dataConfiguration = RepositoryFactory.getDataConfiguration();
		
		this.managerRepositoryService = RepositoryFactory.getManagerRepositoryService();
	}

	@Override
	public void logMessage(UserMessage msg) {
		LOGMSG.info(msg.toString());
//		this.managerRepositoryService.insertLog(msg);
	}

	@Override
	public LocalConfiguration getConfiguration() {
//		LocalConfiguration reciveLocalConfig = this.managerRepositoryService.loadXml();
		LocalConfiguration reciveLocalConfig = new LocalConfiguration(dataConfiguration.getWhoIam(),
				dataConfiguration.getKalTime(), 
				dataConfiguration.getAckTimeout(),
				dataConfiguration.getPort());
		return reciveLocalConfig;
	}
}
