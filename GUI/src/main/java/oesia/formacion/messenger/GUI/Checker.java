package oesia.formacion.messenger.GUI;

import javafx.scene.control.Alert;
import oesia.formacion.messenger.GUI.entities.MessageGui;

public class Checker {
	public static void check(MessageGui item) {
		if (item.getMessage().matches("\\[ALERT\\] .*")) {
			item.setMessage(item.getMessage().split("\\] ")[1]);
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Mensaje Emergente!!!");
			alert.setHeaderText(null);
			alert.setContentText(item.getMessage());
			alert.show();
		}
	}
}
