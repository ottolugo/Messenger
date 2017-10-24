package oesia.formacion.messenger.GUI;

import javafx.scene.control.ListCell;

public class UserFormat extends ListCell<String> {

	@Override
	protected void updateItem(String user, boolean empty) {
		super.updateItem(user, empty);

		if (empty) {
			setText(null);
		} else {
			setText(user.toString());
		}
	}
}
