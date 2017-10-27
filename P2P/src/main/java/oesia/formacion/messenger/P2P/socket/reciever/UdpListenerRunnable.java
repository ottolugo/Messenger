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
import oesia.formacion.messenger.P2P.domain.usecases.UsecaseFactory;
import oesia.formacion.messenger.P2P.logger.LogGet;
import oesia.formacion.messenger.P2P.socket.configuration.SocketInternalConfiguration;

public class UdpListenerRunnable implements Runnable {

	private static final Logger LOG = LogGet.getLogger(UdpListenerRunnable.class);
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
		LOG.log(Level.INFO, "Se lanza el observador del puerto: " + socketPort);
		try {
			// Se saca primero el tamaño del datagrama de la configuracion del
			// socket
			int bytes = SocketInternalConfiguration.DATAGRAMSIZE;
			socket = new DatagramSocket(socketPort);
			byte[] incomingData = new byte[bytes];
			while (true) {
				DatagramPacket datagramPacket = new DatagramPacket(incomingData, incomingData.length);
				socket.receive(datagramPacket);
				// Datos recibidos
				byte[] recievedData = datagramPacket.getData();
				// Lo que se encarga de recibir los datos
				ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(recievedData);
				// Lo que se encarga de convertir los datos
				ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);

				// Casteando a message
				try {
					Object obj = objectInputStream.readObject();
					Message message = (Message) obj;
					UsecaseFactory.getReceiveMessageUsecase(message).run();
					LOG.info("Se recibe el mensage: " + message);
				} catch (ClassNotFoundException e) {
					// Este Catch es por si se recive algo que no sea un objeto
					LOG.log(Level.INFO, "Se recepciono otra cosa");
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
