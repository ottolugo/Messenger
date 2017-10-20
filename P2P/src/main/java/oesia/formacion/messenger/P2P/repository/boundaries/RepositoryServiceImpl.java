package oesia.formacion.messenger.P2P.repository.boundaries;


import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.repository.RepositoryFactory;
import oesia.formacion.messenger.P2P.repository.manager.ManagerRepositoryService;

public class RepositoryServiceImpl implements RepositoryService {

	private final ManagerRepositoryService managerRepositoryService;
	
	public RepositoryServiceImpl() {
		this.managerRepositoryService = RepositoryFactory.getManagerRepositoryService();
	}
	
	@Override
	public void logMessage(UserMessage msg) {
		this.managerRepositoryService.insertLog(msg);
	}

	@Override
	public LocalConfiguration getConfiguration() {
		LocalConfiguration reciveLocalConfig = this.managerRepositoryService.loadXml();
		return reciveLocalConfig;
	}
}
