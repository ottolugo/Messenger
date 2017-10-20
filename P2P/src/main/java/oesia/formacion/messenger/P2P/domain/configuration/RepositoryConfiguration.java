package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.RepositoryServiceImpl;

public class RepositoryConfiguration {
	private static RepositoryService service;

	public static RepositoryService getService() {
		if (service == null) {
			service = new RepositoryServiceImpl();
		}
		return service;
	}
}
