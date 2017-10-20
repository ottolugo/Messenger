package oesia.formacion.messenger.P2P.keepAliver;

import oesia.formacion.messenger.P2P.domain.boundaries.KeepaliverService;

public class KeepAliverImpl implements KeepaliverService {

	@Override
	public void startService() {
		KeepAliverConfiguration.startKeepAlive();

	}

}
