package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.boundaries.FIFOservice;

public class FIFOConfiguration {
	private static FIFOservice service;
	
	public static FIFOservice getFIFOservice(){
		if(service == null){
			//TODO consultar con Javier
		}
		return service;
	}
}
