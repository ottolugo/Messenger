package oesia.formacion.messenger.P2P.socket.senders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.usecases.UsecaseFactory;
import oesia.formacion.messenger.P2P.logger.LogGetter;
import oesia.formacion.messenger.P2P.socket.configuration.SocketInternalConfiguration;

public class SendMessageRunable implements Runnable {

	private static final Logger LOG = LogGetter.getLogger(SendMessageRunable.class);
	private Message message = null;

	public SendMessageRunable(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		// Se preparan los datos para ser enviados
		List<Integer> ports = SocketInternalConfiguration.getPortNumbers();
		DatagramSocket datagramSocket = null;
		int datagramLeng = SocketInternalConfiguration.DATAGRAMSIZE;
		byte[] bufferDatos = new byte[datagramLeng];
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// Se enviará el mensaje para todos los puertos
		for (Integer port : ports) {
			for (String IP : SocketInternalConfiguration.getIPGROUP()) {
				try {
					// Se pasa el objeto a bytes
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
					objectOutputStream.writeObject(message);
					bufferDatos = outputStream.toByteArray();
					// Se saca la direccion a la que hacer el Broadcast
					String sendAdress = IP;
					InetAddress inetAddress = null;
					try {

						inetAddress = InetAddress.getByName(sendAdress);
						DatagramPacket datagramPacket = null;
						datagramPacket = new DatagramPacket(bufferDatos, bufferDatos.length, inetAddress, port);
						datagramSocket = new DatagramSocket();
						datagramSocket.send(datagramPacket);
						UsecaseFactory.getConfirmSentUsecase(message).run();
						LOG.log(Level.INFO,
								"Puerto: " + port + " IP envio: " + IP + " - Mensage enviado:" + message.toString());
						datagramSocket.close();
					} catch (UnknownHostException e1) {
						LOG.log(Level.WARNING, "Fallo en la direccion del Broadcast " + sendAdress);
					}
				} catch (IOException e) {
					LOG.log(Level.WARNING,
							"Se interrumpio el envio del mensage por problemas de envio: " + message.toString() + "\n");
					e.printStackTrace();
				}
			}

		}

	}
}
