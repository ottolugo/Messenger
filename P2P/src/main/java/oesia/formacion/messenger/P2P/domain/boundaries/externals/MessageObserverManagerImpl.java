package oesia.formacion.messenger.P2P.domain.boundaries.externals;

import oesia.formacion.messenger.P2P.domain.managers.MessageNotifierManager;

public class MessageObserverManagerImpl implements MessageObserverManager {

	@Override
	public void addObserver(MessageObserver newObserver) {
		MessageNotifierManager.getInstance().add(newObserver);

	}

	@Override
	public void dropObserver(MessageObserver oldObserver) {
		MessageNotifierManager.getInstance().drop(oldObserver);

	}

}
