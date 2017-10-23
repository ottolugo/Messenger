package oesia.formacion.messenger.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import oesia.formacion.messenger.GUI.boundaries.MessageManager;
import oesia.formacion.messenger.GUI.boundaries.MessageManagerFactory;
import oesia.formacion.messenger.GUI.entities.MessageGui;

public class ChatController implements Initializable {
	@FXML
	ListView<MessageGui> lvMensajes;
	@FXML
	TextArea taMensaje;
	@FXML
	ListView<String> lvUser;
	int cosas = 0;

	public static ObservableList<MessageGui> mensagges = FXCollections.observableArrayList();
	public static ObservableList<String> items = FXCollections.observableArrayList();

	public void initialize(URL arg0, ResourceBundle arg1) {

		lvMensajes.setItems(mensagges);
		lvUser.setItems(items);

		lvMensajes.setCellFactory(new Callback<ListView<MessageGui>, ListCell<MessageGui>>() {

			public ListCell<MessageGui> call(ListView<MessageGui> param) {
				ListCell<MessageGui> cell = new ListCell<MessageGui>() {

					@Override
					protected void updateItem(MessageGui item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item.toString());

							MessageManager mm = MessageManagerFactory.getMessageManager();
							if (item.getSender().equals(mm.whoIAm())) {

								switch (item.getStatus()) {
								case ARRIVED:
									setStyle("-fx-background-color:#ABEBC6");
									setAlignment(Pos.BASELINE_RIGHT);
									break;
								case CANCELED:
									setStyle("-fx-background-color:#F98282;");
									setAlignment(Pos.BASELINE_RIGHT);
									break;
								case NEW:
									setStyle("-fx-background-color:#F0B47D;");
									setAlignment(Pos.BASELINE_RIGHT);
									break;
								case SENT:
									setStyle("-fx-background-color:#F0EA7D");
									setAlignment(Pos.BASELINE_RIGHT);
									break;
								}
							} else {

								setWrapText(true);
								setAlignment(Pos.BASELINE_LEFT);
								setStyle(
										"-fx-border-color: #ABEBC6;-fx-border-insets: 2;-fx-border-width: 2;-fx-border-style: solid;-fx-border-radius: 25px;-fx-background-color:#ABD9EB;");
							}

						}

					}
				};
				return cell;
			}
		});

	}

	@FXML
	public void sendMensaje() {
		if (!taMensaje.getText().equals("")) {
			MessageManager messageManager = new MessageManager();
			MessageGui mensaje = new MessageGui(taMensaje.getText(), messageManager.whoIAm());

			// System.out.println(mensaje);
			mensagges.add(mensaje);
			taMensaje.setText("");
			messageManager.sendMessage(mensaje);

		}
	}

	@FXML
	public void desselectUser() {
		lvUser.getSelectionModel().clearSelection();

	}

}
