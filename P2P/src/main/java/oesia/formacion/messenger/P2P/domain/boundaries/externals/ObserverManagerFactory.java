package oesia.formacion.messenger.P2P.domain.boundaries.externals;

public class ObserverManagerFactory {
	private static MessageObserverManager messageObserverManager = null;
	private static UserListObserverManager userListObserverManager = null;

	public static MessageObserverManager getMessageObserverManager() {
		if (messageObserverManager == null) {
			messageObserverManager = new MessageObserverManagerImpl();
		}
		return messageObserverManager;

	}

	public static UserListObserverManager getUserListObserverManager() {
		if (userListObserverManager == null) {
			userListObserverManager = new UserListObserverManagerImpl();
		}
		return userListObserverManager;

	}

}
