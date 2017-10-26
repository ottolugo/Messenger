package oesia.formacion.messenger.P2P.repository.boundaries;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import oesia.formacion.messenger.P2P.repository.configuration.DataConfiguration;
import oesia.formacion.messenger.P2P.repository.configuration.xmlMessage.XmlMessage;

public class RepositoryFactory {

	private static DataConfiguration dataConfigurationService = null;
	private static XmlMessage xmlMessageService = null;

	public RepositoryFactory() {
	}

	public static DataConfiguration getDataConfiguration() {
		if (dataConfigurationService == null) {
			dataConfigurationService = new DataConfiguration();
			try {
				dataConfigurationService.setDataConfiguration();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dataConfigurationService;
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

}
