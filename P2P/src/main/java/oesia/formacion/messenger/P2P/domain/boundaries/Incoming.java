package oesia.formacion.messenger.P2P.domain.boundaries;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface Incoming {
	public void receive(Message msg);
}
