package oesia.formacion.messenger.P2P.repository.boundaries;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.repository.RepositoryFactory;
import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.configuration.xmlMessage.XmlMessage;

public class RepositoryServiceImpl implements RepositoryService {

//	private final static Logger LOGMSG = Logger.getLogger(RepositoryServiceImpl.class.getName());
	private final DataConfiguration dataConfiguration;
	private XmlMessage xmlMessage;

	public RepositoryServiceImpl() {
//		FileHandler logFileHandler;
//		try {
//			logFileHandler = new FileHandler("../msg.log", true);
//			logFileHandler.setFormatter(new SimpleFormatter());
//			LOGMSG.addHandler(logFileHandler);
//		} catch (SecurityException | IOException e1) {
//		}
		
		xmlMessage = RepositoryFactory.getXmlMessage();
		dataConfiguration = RepositoryFactory.getDataConfiguration();
	}

	@Override
	public void logMessage(UserMessage msg) {
//		LOGMSG.info(msg.toString());
		xmlMessage.insertInDocument(msg);
	}

	@Override
	public LocalConfiguration getConfiguration() {
		LocalConfiguration reciveLocalConfig = new LocalConfiguration(dataConfiguration.getWhoIam(),
				dataConfiguration.getKalTime(), dataConfiguration.getAckTimeout(), dataConfiguration.getPort());
		return reciveLocalConfig;
	}
}
