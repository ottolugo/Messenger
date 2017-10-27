package oesia.formacion.messenger.P2P.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleLogFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuilder formatedText = new StringBuilder();
		formatedText.append(record.getThreadID());
		formatedText.append(" : ");
		formatedText.append(record.getSourceClassName());
		formatedText.append(" : ");
		formatedText.append(record.getSourceMethodName());
		formatedText.append("\n");
		formatedText.append(record.getMessage());
		formatedText.append("\nCode: ");
		formatedText.append(record.getLevel());
		formatedText.append("\n");
		return formatedText.toString();
	}

}
