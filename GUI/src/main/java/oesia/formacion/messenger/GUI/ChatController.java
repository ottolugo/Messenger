package oesia.formacion.messenger.GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

	ObservableList<MessageGui> mensagges;
	ObservableList<String> items;

	public void initialize(URL arg0, ResourceBundle arg1) {
		List<String> prueba = new ArrayList<String>();
		prueba.add("ola");
		prueba.add("cara");
		prueba.add("cola");
		items = FXCollections.observableArrayList(prueba);
		prueba.add("prueba");
		rellenarUser(prueba);

		// lvMensajes.setPrefWidth(40);
		lvMensajes.setMaxWidth(50);
		// setWrapText(true);

		mensagges = FXCollections.observableArrayList();
		System.out.println("Mostrando mensajes de observable list" + mensagges);

		lvMensajes.setItems(mensagges);
		System.out.println("Mostrando mensajes de listView" + lvMensajes.getItems());

		lvMensajes.setCellFactory(new Callback<ListView<MessageGui>, ListCell<MessageGui>>() {

			public ListCell<MessageGui> call(ListView<MessageGui> param) {
				ListCell<MessageGui> cell = new ListCell<MessageGui>() {

					@Override
					protected void updateItem(MessageGui item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							setText(item.toString());
							// System.out.println("hay algo en el item: " +
							// item.toString());
							// TODO Centralizar el messageFactory

							MessageManager mm = MessageManagerFactory.getMessageManager();
							if (item.getSender().equals(mm.whoIAm())) {
								// MessageFactory.getMessageService().whoami())
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
			messageManager.sendMessage(mensaje);
			mensagges.add(mensaje);

			taMensaje.setText("");
		}
	}

	@FXML
	public void desselectUser() {
		lvUser.getSelectionModel().clearSelection();
	}

	public void rellenarUser(List<String> user) {
		// items = FXCollections.observableArrayList(user);
		items.clear();
		items.addAll(user);
		lvUser.setItems(items);
	}

}
