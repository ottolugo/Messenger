package oesia.formacion.messenger.P2P.repository;

import java.io.IOException;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.ManagerRepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.RepositoryServiceImpl;
import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.manager.ManagerRepositoryServiceImpl;

public class RepositoryFactory {

	private static RepositoryService repositoryService = null;
	
	private static ManagerRepositoryService managerRepositoryService = null;
	private static DataConfiguration dataConfigurationService = null;
	
	public RepositoryFactory() { }

	public static ManagerRepositoryService getManagerRepositoryService()
	{
		if(managerRepositoryService == null)
		{
			managerRepositoryService = new ManagerRepositoryServiceImpl();
		}
		
		return managerRepositoryService;
	}
	
	public static DataConfiguration getDataConfiguration()
	{
		if(dataConfigurationService == null)
		{
			dataConfigurationService = new DataConfiguration();
			try {
				dataConfigurationService.setDataConfiguration();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dataConfigurationService;
	}
	
}
