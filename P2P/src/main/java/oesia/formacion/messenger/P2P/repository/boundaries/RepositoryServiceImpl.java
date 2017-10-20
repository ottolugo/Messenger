package oesia.formacion.messenger.P2P.repository.boundaries;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Logger;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import oesia.formacion.messenger.P2P.domain.boundaries.RepositoryService;
import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.util.DateUtil;

public class RepositoryServiceImpl implements RepositoryService {

	private final Logger LOG = Logger.getLogger(RepositoryServiceImpl.class.getName());
	
	
	@Override
	public void logMessage(UserMessage msg) {
		insertLog(msg);
	}

	@Override
	public LocalConfiguration getConfiguration() {
		LocalConfiguration reciveLocalConfig = loadXml();
		return reciveLocalConfig;
	}

	/*
	 * insert a log to the file.
	 */
	private void insertLog(UserMessage msg) {
		// Clases necesarias para insertar en xml.
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("src/LogMsg.xml"));

			// preparar el archivo xml para recibir los datos.
			doc.getDocumentElement().normalize();
			
			// Se crea el nodo principal
			Node nodeMain = doc.getDocumentElement();
			// se agrega una nueva etiqueta al documento
			// Se crea una etiqueta dentro del padre
			Element message = doc.createElement("Message");
			
			// Se crea los atributos de la etiqueta principal.
			if (msg instanceof Message) {
				Message sms = (Message) msg;
				message.setAttribute("user", sms.getCode().getUser());
				
				String dateFormat = DateUtil.format(msg.getCode().getDate());
				
				message.setAttribute("date", dateFormat);

			}
			nodeMain.appendChild(message);
			
			//Se inserta contenido al xml.
			message.appendChild(doc.createTextNode(msg.getContenido()));
			
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/LogMsg.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			LOG.info(MessageFormat.format("Error ParserConfigurationException {0} ", e.getMessage() ));
		} catch (SAXException e) {
			LOG.info(MessageFormat.format("Error SAXException {0} ", e.getMessage() ));
		} catch (IOException e) {
			LOG.info(MessageFormat.format("Error IOException {0} ", e.getMessage() ));
		} catch (TransformerConfigurationException e) {
			LOG.info(MessageFormat.format("Error TransformerConfigurationException {0} ", e.getMessage() ));
		} catch (TransformerException e) {
			LOG.info(MessageFormat.format("Error TransformerException {0} ", e.getMessage() ));
		}
	}
	
	private LocalConfiguration loadXml()
	{
		LocalConfiguration localConfig = null;
		
		try {
			File fXmlFile = new File("src/config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("configuration");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					eElement.getElementsByTagName("Whoami").item(0).getTextContent();
					eElement.getElementsByTagName("KeepAliveTimeout").item(0).getTextContent();
					eElement.getElementsByTagName("MessageTimeout").item(0).getTextContent();
					eElement.getElementsByTagName("port").item(0).getTextContent();
					localConfig = new LocalConfiguration(eElement.getElementsByTagName("Whoami").item(0).getTextContent(),
							Integer.parseInt(eElement.getElementsByTagName("KeepAliveTimeout").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("MessageTimeout").item(0).getTextContent()), 
							Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent()));
				}
			}
			
		} catch (ParserConfigurationException e) {
			LOG.info(MessageFormat.format("Error ParserConfigurationException {0} ", e.getMessage() ));
		} catch (SAXException e) {
			LOG.info(MessageFormat.format("Error SAXException {0} ", e.getMessage() ));
		} catch (IOException e) {
			LOG.info(MessageFormat.format("Error IOException {0} ", e.getMessage() ));
		}
		
		return localConfig;
		
	}
}
