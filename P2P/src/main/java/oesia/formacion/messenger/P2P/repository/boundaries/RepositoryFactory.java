package oesia.formacion.messenger.P2P.repository.boundaries;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.configuration.xmlMessage.XmlMessage;

public class RepositoryFactory {

	private static XmlMessage xmlMessageService = null;
	private static DataConfiguration dataConfigurationService = null;

	public RepositoryFactory() {
	}

	public static XmlMessage getXmlMessage() {
		if (xmlMessageService == null) {
			try {
				xmlMessageService = new XmlMessage();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		}
		return xmlMessageService;
	}

	public static DataConfiguration getDataConfiguration() {
		if (dataConfigurationService == null) {
			dataConfigurationService = new DataConfiguration();
		}
		return dataConfigurationService;
	}

}
