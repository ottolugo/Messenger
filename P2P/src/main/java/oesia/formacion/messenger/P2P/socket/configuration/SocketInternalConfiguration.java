package oesia.formacion.messenger.P2P.socket.configuration;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class SocketInternalConfiguration {
    /**
     * Direcciones a la que se le hace el broadcast
     */
    private static final List<String> IPGROUP = new ArrayList<String>();
    /**
     * Tamaño del datagrama
     */
    public static final int DATAGRAMSIZE = 4096;
    /**
     * puertos que se escuchan y en los que se lanzan
     */
    private static List<Integer> portnumbers = null;

    private SocketInternalConfiguration() {
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
     * Se ocupa de enviar las direcciones de broadcast de los interfaces
     * 
     * @return las direcciones de broadcast
     */
    public static List<String> getIPGROUP() {
	if (IPGROUP.isEmpty()) {
	    try {
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
		    for (InterfaceAddress interfaceAdress : interfaces.nextElement().getInterfaceAddresses())
			if (interfaceAdress.getAddress().isSiteLocalAddress()) {
			    IPGROUP.add(interfaceAdress.getBroadcast().getHostAddress());
			}
		}
	    } catch (SocketException e) {
		e.printStackTrace();
	    }
	}
	return IPGROUP;
    }

}
