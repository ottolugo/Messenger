package oesia.formacion.messenger.P2P.FIFO.boundaries;

import oesia.formacion.messenger.P2P.FIFO.messageManagers.config.MessageManagerConfiguration;
import oesia.formacion.messenger.P2P.FIFO.queue.FifoQueue;
import oesia.formacion.messenger.P2P.domain.boundaries.FIFOservice;
import oesia.formacion.messenger.P2P.domain.entities.Message;

/**
 * FifoServiceImpl implements FifoService, startService make an instance of MessageCheck and starts the thread. put just
 * add messages to the queue for the thread to check.
 * 
 * @author JCAGIGAS
 */
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
