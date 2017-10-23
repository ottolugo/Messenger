package oesia.formacion.messenger.P2P.socket.reciever;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.logger.LogGet;
import oesia.formacion.messenger.P2P.socket.configuration.SocketInternalConfiguration;
import oesia.formacion.messenger.P2P.socket.thread.SocketThreadManager;

public class MessagePortListener {

	private static final Logger LOG = LogGet.getLogger(MessagePortListener.class);
	private int port;

	public MessagePortListener(int port) {
		super();
		this.port = port;
	}

	/**
	 * Se utiliza para lanzar la escucha en el puerto.
	 * 
	 * @param listenPort puerto de escucha en el que empezara a escribir/leer
	 */
	public void start() {
		// Comprueba primero los puertos actuales
		List<Integer> activePorts = SocketInternalConfiguration.getPortNumbers();
		if (!activePorts.contains(new Integer(port))) {
			activePorts.add(new Integer(port));
		}

		// Comprobaremos que no exista un hilo a la escucha de ese puerto
		Map<Integer, Thread> portListenerMaps = SocketThreadManager.getPorListenerThreads();
		if (!portListenerMaps.containsKey(new Integer(port))) {
			// Si no existe ya un Thread lanzado podemos lanzar el nuestro
			UdpListenerRunnable udpListenerRunnable;
			udpListenerRunnable = new UdpListenerRunnable(port);
			Thread thread = new Thread(udpListenerRunnable);
			thread.start();
			SocketThreadManager.addPortListenerThread(port, thread);
		} else {
			LOG.log(Level.SEVERE, "Ya existe un hilo lanzado para la escucha del puerto: " + port);
		}

	}

}
