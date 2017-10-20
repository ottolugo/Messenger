package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.boundaries.KeepAliverService;
import oesia.formacion.messenger.P2P.keepAliver.KeepAliverServiceImpl;

public class KeepaliverConfiguration {
private static KeepAliverService service;
	
	public static KeepAliverService getKeepAliverService(){
		if(service == null){
			service = new KeepAliverServiceImpl();
		}
		return service;
	}
}
