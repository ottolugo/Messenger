package oesia.formacion.messenger.P2P.domain.boundaries.externals;

import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.GuidedMessage;

public interface MessageSendManager {

	public void sendBroadcast(BroadcastMessage message);

	public void sendGuidedMessage(GuidedMessage message);
}
