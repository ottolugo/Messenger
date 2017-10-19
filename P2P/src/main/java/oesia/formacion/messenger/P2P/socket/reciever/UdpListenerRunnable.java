package oesia.formacion.messenger.P2P.socket.reciever;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.managers.SocketMessageManager;
import oesia.formacion.messenger.P2P.socket.configuration.SocketConfiguration;

public class UdpListenerRunnable implements Runnable {

	private static final Logger LOG = Logger.getLogger(UdpListenerRunnable.class.getName());
	private int socketPort = 0;

	/**
	 * Crea un escuchador de puertos para meter en un thread
	 * 
	 * @param port puerto de escucha
	 */
	public UdpListenerRunnable(int port) {
		socketPort = port;
	}

	@Override
	public void run() {
		DatagramSocket socket = null;
		try {
			// Se saca primero el tamaño del datagrama de la configuracion del socket
			int bytes = SocketConfiguration.DATAGRAMSIZE;
			socket = new DatagramSocket(socketPort);
			byte[] incomingData = new byte[bytes];
			while (true) {
				DatagramPacket datagramPacket = new DatagramPacket(incomingData, socketPort);
				// Se pide al socket que este a la escucha
				socket.receive(datagramPacket);
				// Datos recividos
				byte[] recievedData = datagramPacket.getData();
				// Lo que se encarga de recivir los datos
				ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(recievedData);
				// Lo que se encarga de convertir los datos
				ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);

				// Casteando a message
				try {
					Message message = (Message) objectInputStream.readObject();
					LOG.log(Level.INFO, "Se recepciono el mensage con codigo: " + message.getCode().toString());
					SocketMessageManager.receiveMessage(message);

				} catch (ClassNotFoundException e) {
					// Este Catch es por si se recive algo que no sea un objeto
					Object recivido = new Object();
					try {
						recivido = objectInputStream.readObject();
					} catch (ClassNotFoundException e1) {
						LOG.log(Level.INFO, "No llego un objeto");
					}
					LOG.log(Level.INFO, "Se recepciono otra cosa: " + recivido.toString());
				}

			}
		} catch (SocketException e) {
			LOG.log(Level.WARNING, "No se pudo establecer conexion con el socket en el puerto " + socketPort);
		} catch (IOException e) {
			LOG.log(Level.WARNING, "Error de recepcion de datagramas en el puerto " + socketPort);
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}

		}

	}

}