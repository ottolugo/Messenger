package oesia.formacion.messenger.P2P.repository.configuration.xmlMessage;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
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
	DOMSource source;
	File archive;
	StreamResult streamResult;
	Element root;

	public XmlMessage() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder constructor = docFactory.newDocumentBuilder();
		document = constructor.newDocument();

		root = document.createElement("log");
		document.appendChild(root);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		transformer = transformerFactory.newTransformer();
		source = new DOMSource(document);
		streamResult = new StreamResult(new File("mssgLog.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, streamResult);

	}

	public void insertInDocument(UserMessage msg) {
		

		Element messageMain = document.createElement("message");


		if (msg instanceof Message) {
			messageMain.setAttribute("user", msg.getCode().getUser());

			String dateFormat = DateUtil.format(msg.getCode().getDate());
			messageMain.setAttribute("date", dateFormat);

			messageMain.appendChild(document.createTextNode(msg.getContenido()));
			root.appendChild(messageMain);
		}

		try {

			source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, streamResult);

		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
