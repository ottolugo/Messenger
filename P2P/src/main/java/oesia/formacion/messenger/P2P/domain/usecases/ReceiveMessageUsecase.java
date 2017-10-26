package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.configuration.PreprocessorConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;

/**
 * Entrega un mensage a la estacion de preprocesado
 * 
 * @author ramunoz
 *
 */
public class ReceiveMessageUsecase implements Usecase {

	private Message msg;

	/**
	 * Se le entrega el mensage a preprocesar
	 * 
	 * @param msg
	 */
	public ReceiveMessageUsecase(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		PreprocessorConfiguration.getPreprocessorService().put(msg);
	}

}
