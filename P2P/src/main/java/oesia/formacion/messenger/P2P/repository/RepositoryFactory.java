package oesia.formacion.messenger.P2P.repository;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.RepositoryServiceImpl;

public class RepositoryFactory {

	private static RepositoryService repositoryService = null;
	
	
	public RepositoryFactory() { }
	
	public static RepositoryService getRepositoryService()
	{
		if(repositoryService == null)
		{
			repositoryService = new RepositoryServiceImpl();
		}
		
		return repositoryService;
	}
	
}
