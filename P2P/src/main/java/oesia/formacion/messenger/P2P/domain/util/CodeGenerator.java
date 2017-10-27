package oesia.formacion.messenger.P2P.domain.util;

import java.time.LocalDateTime;

import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class CodeGenerator {

	public static Code getMyCode(){
		return new Code(LocalConfiguration.getWhoami(), LocalDateTime.now());
	}
	
}
