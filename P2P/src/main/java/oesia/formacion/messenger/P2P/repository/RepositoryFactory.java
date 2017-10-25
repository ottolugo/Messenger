package oesia.formacion.messenger.P2P.repository;

import java.io.IOException;

import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;

public class RepositoryFactory {

	private static DataConfiguration dataConfigurationService = null;
	
	public RepositoryFactory() { }
	
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
