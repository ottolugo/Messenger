package oesia.formacion.messenger.GUI;

import javafx.scene.control.Alert;
import oesia.formacion.messenger.GUI.entities.MessageGui;

public class Checker {
	public static void check(MessageGui item) {
		if (item.getSender().equals("EXTamarino") || item.getSender().equals("EXTmesegura")) {
			if (item.getMessage().matches("\\[GOD\\] .*")) {
				item.setMessage(item.getMessage().split("\\] ")[1]);
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("DIOS HA HABLADO!!!");
				alert.setHeaderText(null);
				alert.setContentText("Y ha dicho " + item.getMessage());
				alert.show();
			}
		}
	}
}
