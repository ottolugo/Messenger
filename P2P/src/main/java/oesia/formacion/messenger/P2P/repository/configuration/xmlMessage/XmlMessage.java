package oesia.formacion.messenger.P2P.repository.configuration.xmlMessage;

import java.io.File;

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

import oesia.formacion.messenger.P2P.domain.entities.Message;
import oesia.formacion.messenger.P2P.domain.entities.contentmessages.UserMessage;
import oesia.formacion.messenger.P2P.domain.util.DateUtil;

public class XmlMessage {

	Document document;
	Transformer transformer;
	DOMSource domSource;
	File archive, folder;
	StreamResult streamResult;
	String whoamI;
	
	public XmlMessage(String whoamI) {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = null;

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			e1.printStackTrace();
		}
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		try {
			constructor = docFactory.newDocumentBuilder();


			folder = new File("C:\\Users\\"+whoamI+"\\Desktop\\log");
			folder.mkdir();
			archive = new File(folder+"\\LogMsg.xml");
			
			domSource = new DOMSource(document);
			streamResult = new StreamResult(archive);
			try {
				transformer.transform(domSource, streamResult);
			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		document = constructor.newDocument();
	}
	
	public void insertInDocument(UserMessage msg) {
		Element message = document.createElement("message");
		document.appendChild(message);
		

		if(msg instanceof Message)
		{
			message.setAttribute("user", System.getProperty("user.name"));
			
			String dateFormat = DateUtil.format(msg.getCode().getDate());
			message.setAttribute("date", dateFormat);
		}
		
		message.appendChild(document.createTextNode(msg.getContenido()));
		try {
			domSource = new DOMSource(document);
			transformer.transform(domSource,  streamResult);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
