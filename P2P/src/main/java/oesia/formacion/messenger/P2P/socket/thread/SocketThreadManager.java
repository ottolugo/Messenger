package oesia.formacion.messenger.P2P.socket.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import oesia.formacion.messenger.P2P.socket.senders.SendMessageFIFO;

public class SocketThreadManager {

    private static Thread sendThread = null;
    private static Map<Integer, Thread> activePortListenerThreads = null;

    private SocketThreadManager() {
    }

    /**
     * Comprueba que este lanzado el thread que comprueva los envios
     */
    public static void checkSender() {
	if (sendThread == null) {
	    sendThread = new Thread(SendMessageFIFO.getInstance());
	    sendThread.start();
	}
    }

    /**
     * Se añade un nuevo hilo de lectura en un puerto.
     * 
     * @param port
     *            puerto que se lee
     * @param thread
     *            hilo que se ejecuta
     */
    public static void addPortListenerThread(int port, Thread thread) {
	checkInicialiceListenerThread();
	activePortListenerThreads.put(new Integer(port), thread);

    }

    /**
     * Fuerza parar un thread de escucha en un puerto
     * 
     * @param port
     *            puerto que se quiere dejar de escuchar
     */
    public static void stopListenerThread(int port) {
	checkInicialiceListenerThread();
	Thread tostop = null;
	tostop = activePortListenerThreads.get(new Integer(port));
	tostop.interrupt();
	activePortListenerThreads.remove(new Integer(port));
    }

    /**
     * Se saca un puerto de la lista
     * 
     * @param port
     *            puerto que se deja
     */
    public static void dropPortListenerThread(int port) {
	checkInicialiceListenerThread();
	activePortListenerThreads.remove(new Integer(port));
    }

    /**
     * Se reciven los threads activos;
     * 
     * @return
     */
    public static Map<Integer, Thread> getPorListenerThreads() {
	checkInicialiceListenerThread();
	Set<Integer> keys = activePortListenerThreads.keySet();
	keys.iterator();
	for (Integer actualKey : keys) {
	    Thread thread = activePortListenerThreads.get(actualKey);
	    if (!thread.isAlive()) {
		activePortListenerThreads.remove(actualKey, thread);
	    }
	}

	return activePortListenerThreads;
    }

    private static void checkInicialiceListenerThread() {
	if (activePortListenerThreads == null) {
	    activePortListenerThreads = new HashMap<Integer, Thread>();
	}

    }

}
