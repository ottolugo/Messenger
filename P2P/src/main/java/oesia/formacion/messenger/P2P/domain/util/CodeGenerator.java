package oesia.formacion.messenger.P2P.domain.util;

import java.time.LocalDateTime;

import oesia.formacion.messenger.P2P.domain.configuration.Configuration;
import oesia.formacion.messenger.P2P.domain.entities.Code;

public class CodeGenerator {

	public static Code getMyCode(){
		return new Code(Configuration.getConfiguration().getWhoami(), LocalDateTime.now());
	}
	
}
