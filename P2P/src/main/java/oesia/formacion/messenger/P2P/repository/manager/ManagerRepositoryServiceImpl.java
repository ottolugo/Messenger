package oesia.formacion.messenger.P2P.repository.manager;

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

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;
import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.util.DateUtil;
import oesia.formacion.messenger.P2P.repository.boundaries.ManagerRepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.RepositoryServiceImpl;

public class ManagerRepositoryServiceImpl implements ManagerRepositoryService {

	private final Logger LOG = Logger.getLogger(RepositoryServiceImpl.class.getName());

	private static Document document;

	public ManagerRepositoryServiceImpl() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = null;
		try {
			constructor = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		// Creamos el documento XML
		document = constructor.newDocument();
	}
	
	@Override
	public void insertLog(UserMessage msg) {
		
		insertInDocument(msg);
		try {
			writeToArchive();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			LOG.info(MessageFormat.format("Error TransformerXMLConfigurationException {0} ", e.getMessage()));
		} catch (TransformerException e) {
			e.printStackTrace();
			LOG.info(MessageFormat.format("Error XMLTransformerException {0} ", e.getMessage()));
		}
	}

	@Override
	public LocalConfiguration loadXml() {
		LocalConfiguration localConfig = null;

		try {
			File fXmlFile = new File(RepositoryServiceImpl.class.getResource("../configuration/config.xml").getFile());
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

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
					localConfig = new LocalConfiguration(
							eElement.getElementsByTagName("Whoami").item(0).getTextContent(),
							Integer.parseInt(
									eElement.getElementsByTagName("KeepAliveTimeout").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("MessageTimeout").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent()));
				}
			}

		} catch (ParserConfigurationException e) {
			LOG.info(MessageFormat.format("Error ParserConfigurationException {0} ", e.getMessage()));
		} catch (SAXException e) {
			LOG.info(MessageFormat.format("Error SAXException {0} ", e.getMessage()));
		} catch (IOException e) {
			LOG.info(MessageFormat.format("Error IOException {0} ", e.getMessage()));
		}

		return localConfig;
	}

	@Override
	public String loadDirXml() {

		String toretDir = null;

		try {
			File fXmlFile = new File(RepositoryServiceImpl.class.getResource("../configuration/config.xml").getFile());
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

					eElement.getElementsByTagName("dir").item(0).getTextContent();
					toretDir = eElement.getElementsByTagName("dir").item(0).getTextContent();
				}
			}

		} catch (ParserConfigurationException e) {
			LOG.info(MessageFormat.format("Error XMLParserConfigurationException {0} ", e.getMessage()));
		} catch (SAXException e) {
			LOG.info(MessageFormat.format("Error SAXException {0} ", e.getMessage()));
		} catch (IOException e) {
			LOG.info(MessageFormat.format("Error IOExceptionXML {0} ", e.getMessage()));
		}

		return toretDir;
	}
	
	public void writeToArchive() throws TransformerConfigurationException, TransformerException {

		// Creamos el objecto transformador
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		// Crear dir
		File folderLog = new File(loadDirXml() + "/log");

		// Archivo donde almacenaremos el XML
		File archivo = new File(folderLog + "/LogMsg.xml");

		// Fuente de datos, en este caso el documento XML
		DOMSource source = new DOMSource(document);
		// Resultado, el cual almacena en el archivo indicado
		StreamResult result = new StreamResult(archivo);
		// Transformamos de ña fuente DOM a el resultado, lo que almacena todo
		// en el archivo
		transformer.transform(source, result);
	}

	public void insertInDocument(UserMessage msg) {
		// Creamos el elemento principal
		Element message = document.createElement("Message");
		// Hacemos el elemento entrada descender directo del nodo XML principal
		document.appendChild(message);
		// Se crea los atributos de la etiqueta principal.
		if (msg instanceof Message) {
			Message sms = (Message) msg;
			message.setAttribute("user", sms.getCode().getUser());

			String dateFormat = DateUtil.format(msg.getCode().getDate());

			message.setAttribute("date", dateFormat);

		}

		message.appendChild(document.createTextNode(msg.getContenido()));
	}

}
