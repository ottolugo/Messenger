package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.util.MessageCache;

public class CacheConfiguration {
	private static MessageCache cache;
	
	public static MessageCache getMessageCache(){
		if(cache == null){
			cache = new MessageCache();
		}
		return cache;
	}
}
