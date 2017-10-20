package oesia.formacion.messenger.P2P.socket.configuration;

import java.util.ArrayList;
import java.util.List;

public class SocketConfiguration {
	/**
	 * Direccion a la que se le hace el broadcast
	 */
	private static final String IPGROUP = "10.236.50.255";
	/**
	 * Tamaño del datagrama
	 */
	public static final int DATAGRAMSIZE = 4096;
	/**
	 * puertos que se escuchan y en los que se lanzan
	 */
	private static List<Integer> portnumbers = null;

	private SocketConfiguration() {
	}

	/**
	 * devuelve el listado de puertos que estan en uso
	 * 
	 * @return listado de puertos que estan en uso
	 */
	public static List<Integer> getPortNumbers() {
		if (portnumbers == null) {
			portnumbers = new ArrayList<Integer>();
		}
		return portnumbers;
	}

	/**
	 * Se ocupa de enviar la direccion de broadcast
	 * 
	 * @return la direccion de broadcast
	 */
	public static String getIPGROUP() {
		return IPGROUP;
	}

}
