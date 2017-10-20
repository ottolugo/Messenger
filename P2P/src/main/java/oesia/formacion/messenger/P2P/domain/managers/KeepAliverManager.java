package oesia.formacion.messenger.P2P.domain.managers;

import oesia.formacion.messenger.P2P.domain.configuration.KeepAliveConfiguration;
import oesia.formacion.messenger.P2P.domain.configuration.SocketConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Code;
import oesia.formacion.messenger.P2P.domain.entities.advicemessages.KeepAliveMessage;
import oesia.formacion.messenger.P2P.domain.util.CodeGenerator;

public class KeepAliverManager {

	/**
	 * Used by the keepaliver to make us send a keepalive message
	 */
	public static void sendKeepAlive() {
		Code newCode = CodeGenerator.getMyCode();
		SocketConfiguration.getService().sendMessage(new KeepAliveMessage(newCode));
		KeepAliveConfiguration.updateKeepAliveCode(newCode);
	}

}
