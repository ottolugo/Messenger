package oesia.formacion.messenger.P2P.repository.manager;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
import oesia.formacion.messenger.P2P.logger.LogGet;
import oesia.formacion.messenger.P2P.repository.boundaries.ManagerRepositoryService;
import oesia.formacion.messenger.P2P.repository.boundaries.RepositoryServiceImpl;

public class ManagerRepositoryServiceImpl implements ManagerRepositoryService {

	private final Logger LOG = LogGet.getLogger(RepositoryServiceImpl.class);
	private final Logger LOGMSG = Logger.getLogger(ManagerRepositoryServiceImpl.class.getName());

	private static Document document;
	private static boolean created = false;
	private static boolean isCreated = false;

	public ManagerRepositoryServiceImpl() {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = null;
		try {
			constructor = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		document = constructor.newDocument();
	}

//	@Override
//	public void insertLog(UserMessage msg) {
//		
//		try {
//			insertInDocument(msg);
//			if(!isCreated)
//			{
//				isCreated = writeToArchive();
//			}
//			
//		} catch (TransformerConfigurationException e) {
//			e.printStackTrace();
//			LOG.info(MessageFormat.format("Error TransformerXMLConfigurationException {0} ", e.getMessage()));
//		} catch (TransformerException e) {
//			e.printStackTrace();
//			LOG.info(MessageFormat.format("Error XMLTransformerException {0} ", e.getMessage()));
//		}
//	}
	

//	public boolean writeToArchive() throws TransformerConfigurationException, TransformerException {
//
//		// Creamos el objecto transformador
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//		StreamResult result = null;
//
//		// Crear dir
//		File folderLog = new File(loadDirXml() + "/log");
//		// Archivo donde almacenaremos el XML
//		
//		if(!created)
//		{
//			File archivo = new File(folderLog + "/LogMsg.xml");
//			folderLog.mkdir();
//			result = new StreamResult(archivo);
//			created = true;
//		}
//		else{
//			File archivo = new File(folderLog + "/LogMsg.xml");
//			result = new StreamResult(archivo);
//			created = true;
//		}
//
//		DOMSource source = new DOMSource(document);
//		transformer.transform(source, result);
//		
//		return created;
//	}

	public void insertInDocument(UserMessage msg) {
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

	@Override
	public void insertLog(UserMessage msg) {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	@Override
//	public LocalConfiguration loadXml() {
//		LocalConfiguration localConfig = null;
//
//		try {
//			File fXmlFile = new File(RepositoryServiceImpl.class.getResource("../configuration/config.xml").getFile());
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//
//			Document doc = dBuilder.parse(fXmlFile);
//
//			doc.getDocumentElement().normalize();
//
//			NodeList nList = doc.getElementsByTagName("configuration");
//
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//
//				Node nNode = nList.item(temp);
//
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//					Element eElement = (Element) nNode;
//
//					eElement.getElementsByTagName("Whoami").item(0).getTextContent();
//					eElement.getElementsByTagName("KeepAliveTimeout").item(0).getTextContent();
//					eElement.getElementsByTagName("MessageTimeout").item(0).getTextContent();
//					eElement.getElementsByTagName("port").item(0).getTextContent();
//					localConfig = new LocalConfiguration(
//							eElement.getElementsByTagName("Whoami").item(0).getTextContent(),
//							Integer.parseInt(
//									eElement.getElementsByTagName("KeepAliveTimeout").item(0).getTextContent()),
//							Integer.parseInt(eElement.getElementsByTagName("MessageTimeout").item(0).getTextContent()),
//							Integer.parseInt(eElement.getElementsByTagName("port").item(0).getTextContent()));
//				}
//			}
//
//		} catch (ParserConfigurationException e) {
//			LOG.info(MessageFormat.format("Error ParserConfigurationException {0} ", e.getMessage()));
//		} catch (SAXException e) {
//			LOG.info(MessageFormat.format("Error SAXException {0} ", e.getMessage()));
//		} catch (IOException e) {
//			LOG.info(MessageFormat.format("Error IOException {0} ", e.getMessage()));
//		}
//
//		return localConfig;
//	}
	
//	@Override
//	public String loadDirXml() {
//
//		String toretDir = null;
//
//		try {
//			File fXmlFile = new File(RepositoryServiceImpl.class.getResource("../configuration/config.xml").getFile());
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder;
//			dBuilder = dbFactory.newDocumentBuilder();
//
//			Document doc = dBuilder.parse(fXmlFile);
//
//			doc.getDocumentElement().normalize();
//
//			NodeList nList = doc.getElementsByTagName("configuration");
//
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//
//				Node nNode = nList.item(temp);
//
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//					Element eElement = (Element) nNode;
//
//					eElement.getElementsByTagName("dir").item(0).getTextContent();
//					toretDir = eElement.getElementsByTagName("dir").item(0).getTextContent();
//				}
//			}
//
//		} catch (ParserConfigurationException e) {
//			LOG.info(MessageFormat.format("Error XMLParserConfigurationException {0} ", e.getMessage()));
//		} catch (SAXException e) {
//			LOG.info(MessageFormat.format("Error SAXException {0} ", e.getMessage()));
//		} catch (IOException e) {
//			LOG.info(MessageFormat.format("Error IOExceptionXML {0} ", e.getMessage()));
//		}
//
//		return toretDir;
//	}
}
