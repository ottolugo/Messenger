package oesia.formacion.messenger.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ChatController implements Initializable {
	@FXML
	ListView<String> lvMensajes;
	@FXML
	TextArea taMensaje;
	@FXML
	ListView<String> lvUser;
	ObservableList<String> mensagges;
	ObservableList<String> items;

	public void initialize(URL arg0, ResourceBundle arg1) {

		items = FXCollections.observableArrayList("A", "B", "C", "D");

		lvUser.setItems(items);

		mensagges = FXCollections.observableArrayList("Maria 15:50:23: Hola que ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?", "Alejandro: 15:51:00: Programar y tu q ase?",
				"Alejandro: 15:51:00: Programar y tu q ase?"

		);

		lvMensajes.setPrefHeight(500);

		lvMensajes.setStyle("-fx-background-color: #FFFFFF;");
		lvMensajes.setItems(mensagges);

	}

	public void sendMensaje() {
		mensagges.add(taMensaje.getText());
		lvMensajes.setItems(mensagges);
		taMensaje.setText("");
	}

	public void desselectUser() {
		lvUser.getSelectionModel().clearSelection();
	}

}
