package oesia.formacion.messenger.P2P.repository.boundaries;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.configuration.xmlMessage.XmlMessage;

public class RepositoryServiceImpl implements RepositoryService {

	private final DataConfiguration dataConfiguration;
	private XmlMessage xmlMessage;

	public RepositoryServiceImpl() {
		xmlMessage = RepositoryFactory.getXmlMessage();
		dataConfiguration = RepositoryFactory.getDataConfiguration();
	}

	@Override
	public void logMessage(UserMessage msg) {
		xmlMessage.insertInDocument(msg);
	}

	@Override
	public void loadConfiguration() {
		LocalConfiguration.loadConfiguration(dataConfiguration.getWhoIam(),
				dataConfiguration.getKalTime(), dataConfiguration.getAckTimeout(), dataConfiguration.getPort());
	}
}
