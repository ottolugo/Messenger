package oesia.formacion.messenger.GUI;

import javafx.scene.control.Alert;
import oesia.formacion.messenger.GUI.entities.MessageGui;

public class Checker {
	public static void check(MessageGui item, boolean god) {
		if (god) {
			if (item.getSender().equals("EXTamarino")) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("DIOS HA HABLADO!!!");
				alert.setHeaderText(null);
				alert.setContentText("Y ha dicho " + item.getMessage());
				alert.showAndWait();
			}
		}
	}
}
