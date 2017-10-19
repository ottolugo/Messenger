package oesia.formacion.messenger.P2P.socket.senders;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.socket.configuration.SocketConfiguration;

public class SendMessageRunable implements Runnable {

	private static final Logger LOG = Logger.getLogger(SendMessageRunable.class.getName());
	private Message message = null;

	public SendMessageRunable(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		// Se preparan los datos para ser enviados
		List<Integer> ports = SocketConfiguration.getPortNumbers();
		DatagramSocket datagramSocket = null;
		int datagramLeng = SocketConfiguration.DATAGRAMSIZE;
		byte[] bufferDatos = new byte[datagramLeng];

		// Se enviara el mensage para todos los puertos
		for (Integer port : ports) {
			try {

				// Se saca la direccion a la que hacer el Broadcast
				String sendAdress = SocketConfiguration.getIPGROUP();
				InetAddress inetAddress = null;
				try {

					inetAddress = InetAddress.getByName(sendAdress);
					DatagramPacket datagramPacket = null;
					datagramPacket = new DatagramPacket(bufferDatos, bufferDatos.length, inetAddress, port);
					datagramSocket = new DatagramSocket();
					datagramSocket.send(datagramPacket);

					datagramSocket.close();
				} catch (UnknownHostException e1) {
					LOG.log(Level.WARNING, "Fallo en la direccion del Broadcast " + sendAdress);
				}
				DatagramPacket datagramPacket = null;
				datagramPacket = new DatagramPacket(bufferDatos, bufferDatos.length, inetAddress, port);
				datagramSocket = new DatagramSocket();
				datagramSocket.send(datagramPacket);

				datagramSocket.close();
			} catch (IOException e) {
				LOG.log(Level.WARNING,
						"Se interrumpio el envio del mensage por problemas de envio: " + message.toString());
			}
		}

	}

}
