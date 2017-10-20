package oesia.formacion.messenger.P2P.domain.configuration;

import oesia.formacion.messenger.P2P.domain.boundaries.PreprocessorService;
import oesia.formacion.messenger.P2P.preprocessor.boundaries.PreprocessorServiceImpl;

public class PreprocessorConfiguration {
	private static PreprocessorService service;
	
	public static PreprocessorService getPreprocessorService(){
		if(service == null){
			service = new PreprocessorServiceImpl();
		}
		return service;
	}
}
