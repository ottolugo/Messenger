package oesia.formacion.messenger.P2P.socket.boundaries;

import oesia.formacion.messenger.P2P.domain.boundaries.SocketService;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.socket.reciever.MessagePortListener;
import oesia.formacion.messenger.P2P.socket.senders.SendMessageManager;

public class SocketServiceImpl implements SocketService {

	private static SocketServiceImpl instance = null;

	private SocketServiceImpl() {
	}

	/**
	 * Singleton
	 * 
	 * @return unique instance
	 */
	public static SocketServiceImpl getInstance() {
		if (instance == null) {
			instance = new SocketServiceImpl();
		}
		return instance;
	}

	@Override
	public void sendMessage(Message msg) {
		SendMessageManager.sendMessage(msg);

	}

	@Override
	public void startService(int port) {
		MessagePortListener messagePortListener;
		messagePortListener = new MessagePortListener(port);
		messagePortListener.start();

	}

}
