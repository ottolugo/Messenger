package oesia.formacion.messenger.P2P.domain.usecases;

import oesia.formacion.messenger.P2P.domain.configuration.PreprocessorConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;

/**
 * Entrega un mensage a la estacion de preprocesado
 * 
 * @author ramunoz
 *
 */
public class MessageSocketReception implements Usecase<Void> {

	private Message msg;

	/**
	 * Se le entrega el mensage a preprocesar
	 * 
	 * @param msg
	 */
	public MessageSocketReception(Message msg) {
		this.msg = msg;
	}

	@Override
	public Void run() {
		PreprocessorConfiguration.getPreprocessorService().put(msg);
		return null;
	}

}
