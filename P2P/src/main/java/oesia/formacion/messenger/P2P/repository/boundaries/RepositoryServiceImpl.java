package oesia.formacion.messenger.P2P.repository.boundaries;

import java.io.IOException;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.configuration.xmlMessage.XmlMessage;

public class RepositoryServiceImpl implements RepositoryService {

	private final XmlMessage xmlMessage;
	private final DataConfiguration data;

	public RepositoryServiceImpl() {
		xmlMessage = RepositoryFactory.getXmlMessage();
		data = RepositoryFactory.getDataConfiguration();
	}

	@Override
	public void logMessage(UserMessage msg) {
		xmlMessage.insertInDocument(msg);
	}

	@Override
	public void loadConfiguration() {
		DataConfiguration data = DataConfiguration.getDataConfiguration();
		LocalConfiguration.loadConfiguration(data.getWhoIam(), data.getKalTime(), data.getAckTimeout(), data.getPort());
	}
}
