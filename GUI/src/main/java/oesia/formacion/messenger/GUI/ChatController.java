package oesia.formacion.messenger.GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
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

		items = FXCollections.observableArrayList("A", "B", "C", "D");

		lvUser.setItems(items);

		lvMensajes.getStylesheets().add(getClass().getResource("send.css").toExternalForm());
		lvMensajes.setPrefHeight(500);
		List<MessageGui> listM = new ArrayList<MessageGui>();
		listM.add(new MessageGui("Hola que ase", "Maria"));
		mensagges = FXCollections.observableArrayList(listM);
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
							System.out.println("hay algo en el item: " + item.toString());
						}
						// else {
						// setText("tEXTO CAMBIADO");
						// System.out.println("ITEM NULL nº: " + cosas++);
						// }
					}
				};
				return cell;
			}
		});
		/*
		 * lvMensajes.setCellFactory(new Callback<ListView<MessageGui>,
		 * ListCell<MessageGui>>() {
		 * 
		 * public ListCell<MessageGui> call(ListView<MessageGui> p) { final Text
		 * text = new Text(); final ListCell<MessageGui> cell = new
		 * ListCell<MessageGui>() {
		 * 
		 * @Override public void updateItem(MessageGui item, boolean empty) {
		 * super.updateItem(item, empty); if (item != null) { if
		 * (item.getStatus() == MessageStatusGui.CANCELED) {
		 * text.setFill(Color.RED); } // TODO, PROBAR Y TERMINAR DE RELLENAR LOS
		 * COLORES, // MEJOR PONER UN SWITCH, ESOT ES UNA PRUEBA
		 * 
		 * // text.setContent(item.getMessage()); //
		 * cell.setText(item.getMessage());
		 * 
		 * // setNode(text); } else {
		 * System.out.println("item es igual a null"); } }
		 * 
		 * }; return cell; }
		 * 
		 * });
		 */

	}

	@FXML
	public void sendMensaje() {
		// mensagges.add(taMensaje.getText());
		// lvMensajes.setItems(mensagges);
		// taMensaje.setText("");
	}

	@FXML
	public void desselectUser() {
		lvUser.getSelectionModel().clearSelection();
	}

}
