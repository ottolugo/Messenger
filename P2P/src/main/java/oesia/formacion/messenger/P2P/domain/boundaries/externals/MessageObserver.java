package oesia.formacion.messenger.P2P.domain.boundaries.externals;

import oesia.formacion.messenger.P2P.domain.entities.Message;

public interface MessageObserver {

	/**
	 * Se usa para notificar mensages recividos
	 * 
	 * @param message
	 */
	public void notify(Message message);

}
