package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface Outgoing {
	public void send(Message msg);
}
