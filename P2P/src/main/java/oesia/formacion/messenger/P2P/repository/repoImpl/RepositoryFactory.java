package oesia.formacion.messenger.P2P.repository.repoImpl;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;

public class RepositoryFactory {

	private static RepositoryService repositoryService = null;

	public RepositoryFactory() {
	}

	public static RepositoryService getRepositoryService() {
		if (repositoryService == null) {
			repositoryService = new RepositoryServiceImpl();
		}

		return repositoryService;
	}
}
