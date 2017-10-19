package oesia.formacion.messenger.P2P.FIFO;

import oesia.formacion.messenger.P2P.domain.boundaries.FIFOservice;
import oesia.formacion.messenger.P2P.domain.entities.Message;

public class FIFOServiceImpl implements FIFOservice {
	@Override
	public void startService() {
		MessageManagerConfiguration.startMessageManager();

	}

	@Override
	public void put(Message msg) {
		FifoQueue.addMessage(msg);

	}

}
