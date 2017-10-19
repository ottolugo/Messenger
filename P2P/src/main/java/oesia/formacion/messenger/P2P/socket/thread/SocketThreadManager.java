package oesia.formacion.messenger.P2P.socket.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SocketThreadManager {

	private static List<Thread> activeSendMessageThreads = null;
	private static Map<Integer, Thread> activePortListenerThreads = null;
	private static Semaphore sendMessagePortSemaphore = null;

	private SocketThreadManager() {
	}

	/**
	 * Cuando se crea un thread para mandar un mensage nuevo lo agrega al listado
	 * 
	 * @param thread que se lanzo para la insercion
	 */
	public static void addSendMessageThread(Thread thread) {
		checkinitialiceSendMessageThreads();
		activeSendMessageThreads.add(thread);
	}

	/**
	 * Se elimina un thread de la lista de envios por que acabo o no se necesita
	 * 
	 * @param thread a eliminar
	 */
	public static void dropSendMessageThread(Thread thread) {
		checkinitialiceSendMessageThreads();
		activeSendMessageThreads.remove(thread);
	}

	/**
	 * Se devuelve el listado de mensages activos
	 * 
	 * @return lista de thread activos para envio de mensages
	 */
	public static List<Thread> getActiveSendMessageThreads() {
		checkinitialiceSendMessageThreads();
		Iterator<Thread> threadIterator = activeSendMessageThreads.iterator();
		while (threadIterator.hasNext()) {
			Thread active = threadIterator.next();
			if (!active.isAlive()) {
				dropSendMessageThread(active);
			}
		}
		return activeSendMessageThreads;
	}

	/**
	 * Se añade un nuevo hilo de lectura en un puerto.
	 * 
	 * @param port puerto que se lee
	 * @param thread hilo que se ejecuta
	 */
	public static void addPortListenerThread(int port, Thread thread) {
		checkInicialiceListenerThread();
		activePortListenerThreads.put(new Integer(port), thread);

	}

	/**
	 * Fuerza parar un thread de escucha en un puerto
	 * 
	 * @param port puerto que se quiere dejar de escuchar
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
	 * @param port puerto que se deja
	 */
	public static void dropPortListenerThread(int port) {
		activePortListenerThreads.remove(new Integer(port));
	}

	/**
	 * Se reciven los threads activos;
	 * 
	 * @return
	 */
	public static Map<Integer, Thread> getPorListenerThreads() {
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

	/**
	 * para evitar que se manden nuevos mensages sin acabar antes de mandar uno.
	 * 
	 * @return el semaforo para los diferentes envios
	 */
	public static Semaphore getSendMessageSemaphore() {
		if (sendMessagePortSemaphore == null) {
			sendMessagePortSemaphore = new Semaphore(1);
		}
		return sendMessagePortSemaphore;
	}

	private static void checkInicialiceListenerThread() {
		if (activePortListenerThreads == null) {
			activePortListenerThreads = new HashMap<Integer, Thread>();
		}

	}

	private static void checkinitialiceSendMessageThreads() {
		if (activeSendMessageThreads == null) {
			activeSendMessageThreads = new ArrayList<Thread>();
		}

	}
}
