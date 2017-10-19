package oesia.formacion.messenger.P2P.repository.repoImpl;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;

public class RepositoryServiceImpl implements RepositoryService {

	private final RepositoryService repositoryService;
	
	public RepositoryServiceImpl() {
		this.repositoryService = RepositoryFactory.getRepositoryService();
	}
	
	@Override
	public void logMessage(BroadcastMessage msg) {
		
	}

	@Override
	public LocalConfiguration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
