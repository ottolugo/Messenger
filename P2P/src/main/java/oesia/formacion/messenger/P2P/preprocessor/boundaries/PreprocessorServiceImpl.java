package oesia.formacion.messenger.P2P.preprocessor.boundaries;

import oesia.formacion.messenger.P2P.domain.boundaries.PreprocessorService;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.FIFOQueueManager;
import oesia.formacion.messenger.P2P.preprocessor.messageManagers.config.MessageManagerConfiguration;

/**
 * FifoServiceImpl implements FifoService, startService make an instance of
 * MessageCheck and starts the thread. put just add messages to the queue for
 * the thread to check.
 * 
 * @author JCAGIGAS
 */
public class PreprocessorServiceImpl implements PreprocessorService {

    @Override
    public void startService() {
	MessageManagerConfiguration.startMessageManager();

    }

    @Override
    public void put(Message msg) {
	FIFOQueueManager.getFIFOQueue().addMessage(msg);
    }

}
