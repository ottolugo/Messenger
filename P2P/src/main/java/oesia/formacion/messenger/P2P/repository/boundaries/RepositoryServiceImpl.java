package oesia.formacion.messenger.P2P.repository.boundaries;

import java.io.IOException;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.configuration.xmlMessage.XmlMessage;

public class RepositoryServiceImpl implements RepositoryService {

	private final XmlMessage xmlMessage;

	public RepositoryServiceImpl() {
		xmlMessage = RepositoryFactory.getXmlMessage();
	}

	@Override
	public void logMessage(UserMessage msg) {
		xmlMessage.insertInDocument(msg);
	}

	@Override
	public void loadConfiguration() {
		try {
			DataConfiguration.setDataConfiguration();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LocalConfiguration.loadConfiguration(DataConfiguration.getWhoIam(), DataConfiguration.getKalTime(),
				DataConfiguration.getAckTimeout(), DataConfiguration.getPort());
	}
}
