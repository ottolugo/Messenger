package oesia.formacion.messenger.P2P.preprocessor.preprocessor;

import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.usecases.UsecaseFactory;
import oesia.formacion.messenger.P2P.logger.LogGet;
import oesia.formacion.messenger.P2P.preprocessor.queue.FIFOQueue;
import oesia.formacion.messenger.P2P.preprocessor.util.PreprocessorChecker;

/**
 * 
 * this thread check the fifo queue and depending on the message calls a MessageManager to do its job(manageMessage)
 * 
 * @author jcagigas
 *
 */
public class MessagePreprocessor extends Thread {
	private static final Logger LOG = LogGet.getLogger(MessagePreprocessor.class);

	/*
	 * Constructor which main function is to instance all the Message Managers
	 */
	public MessagePreprocessor() {
	}

	@Override
	public void run() {
		while (true) {
			try {
				// El sleep se introduce para que no se cuelgue el hilo al hacer
				// espera activa
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (FIFOQueue.getFIFO().gotMessages()) {
				Message message = FIFOQueue.getFIFO().getMessage();
				if (PreprocessorChecker.check(message)) {
					UsecaseFactory.getProcessMessageUsecase(message).run();
					LOG.log(Level.FINE, "Message passed preprocessing" + message);
				} else {
					LOG.log(Level.FINE, "Message did not pass preprocessing" + message);
				}
			}
		}
	}

}
