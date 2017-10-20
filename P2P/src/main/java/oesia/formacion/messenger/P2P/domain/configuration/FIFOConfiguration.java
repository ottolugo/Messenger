package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.FIFO.boundaries.FIFOServiceImpl;
import oesia.formacion.messenger.P2P.domain.boundaries.FIFOservice;

public class FIFOConfiguration {
	private static FIFOservice service;
	
	public static FIFOservice getFIFOservice(){
		if(service == null){
			service = new FIFOServiceImpl();
		}
		return service;
	}
}
