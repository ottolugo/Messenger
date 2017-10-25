package oesia.formacion.messenger.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import oesia.formacion.messenger.GUI.boundaries.MessageManager;
import oesia.formacion.messenger.GUI.boundaries.MessageManagerFactory;
import oesia.formacion.messenger.GUI.entities.MessageGui;

public class ItemFormat extends ListCell<MessageGui> {

	@Override
	protected void updateItem(MessageGui item, boolean empty) {
		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setStyle("-fx-background-color:#ffff");
		} else {
			StringBuilder sb = new StringBuilder(item.toString());
			int i = sb.indexOf("\n");
			while ((i = sb.indexOf(" ", i + 20)) != -1) {
				sb.replace(i, i + 1, "\n");
			}
			setText(sb.toString());
			MessageManager mm = MessageManagerFactory.getMessageManager();
			if (item.getSender().equals(mm.whoIAm())) {
				setStyle("-fx-dark-text-color: rgb(50, 50, 50);;-fx-background-color:" + item.getStatus().getColor());
				setAlignment(Pos.BASELINE_RIGHT);

			} else {
				Checker.check(item, false);
				setWrapText(true);
				setAlignment(Pos.BASELINE_LEFT);
				setStyle(
						"-fx-border-color: #ABEBC6;-fx-border-insets: 2;-fx-border-width: 2;-fx-border-style: solid;-fx-border-radius: 25px;-fx-background-color:#ABD9EB;-fx-color:black");
			}

		}
	}
}
