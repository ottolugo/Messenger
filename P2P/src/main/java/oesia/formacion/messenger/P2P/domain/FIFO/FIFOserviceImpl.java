package oesia.formacion.messenger.P2P.domain.FIFO;

import oesia.formacion.messenger.P2P.domain.boundaries.FIFOservice;
import oesia.formacion.messenger.P2P.domain.entities.Message;

public class FIFOserviceImpl implements FIFOservice {
	private final FifoStack fifo;

	public FIFOserviceImpl() {
		this.fifo = FifoFactory.ge
	}

	@Override
	public void put(Message msg) {
		fifo.addMessage(msg);

	}

}
