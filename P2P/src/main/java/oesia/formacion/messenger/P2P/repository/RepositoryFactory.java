package oesia.formacion.messenger.P2P.repository;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.RepositoryServiceImpl;
import oesia.formacion.messenger.P2P.repository.manager.ManagerRepositoryService;
import oesia.formacion.messenger.P2P.repository.manager.ManagerRepositoryServiceImpl;

public class RepositoryFactory {

	private static RepositoryService repositoryService = null;
	
	private static ManagerRepositoryService managerRepositoryService = null;
	
	public RepositoryFactory() { }
	
	public static RepositoryService getRepositoryService()
	{
		if(repositoryService == null)
		{
			repositoryService = new RepositoryServiceImpl();
		}
		
		return repositoryService;
	}
	
	public static ManagerRepositoryService getManagerRepositoryService()
	{
		if(managerRepositoryService == null)
		{
			managerRepositoryService = new ManagerRepositoryServiceImpl();
		}
		
		return managerRepositoryService;
	}
	
}
