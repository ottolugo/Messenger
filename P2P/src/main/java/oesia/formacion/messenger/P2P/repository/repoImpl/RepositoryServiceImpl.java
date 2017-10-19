package oesia.formacion.messenger.P2P.repository.repoImpl;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.BroadcastMessage;

public class RepositoryServiceImpl implements RepositoryService {

	@Override
	public void logMessage(BroadcastMessage msg) {
		insertLog(msg);
	}

	@Override
	public LocalConfiguration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * insert a broadcast to the file.
	 */
	private void insertLog(BroadcastMessage msg) {
		// Clases necesarias para insertar en xml.
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("src/LogMsg.xml"));

			// preparar el archivo xml para recibir los datos.
			doc.getDocumentElement().normalize();
			// Se obtiene el nodo padre de LogMsg
			Node nodeMain = doc.getDocumentElement();
			// se agrega una nueva etiqueta al documento
			// Se crea una etiqueta dentro del padre
			Element message = doc.createElement("Message");
			// Se crea las etiquetas hijas.
			if (msg instanceof Message) {
				Message sms = (Message) msg;
				message.setAttribute("user", sms.getCode().getUser());
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	        
				String dateFormat = msg.getCode().getDate().format(formatter);
				message.setAttribute("date", dateFormat);
				

			}
			nodeMain.appendChild(message);
			
			message.appendChild(doc.createTextNode(msg.getContenido()));
			
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/LogMsg.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
	}

}
