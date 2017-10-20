package oesia.formacion.messenger.P2P.keepAliver;

import oesia.formacion.messenger.P2P.domain.boundaries.KeepAliverService;

public class KeepAliverServiceImpl implements KeepAliverService {

	@Override
	public void startService() {
		KeepAliverConfiguration.startKeepAlive();
	}

}
