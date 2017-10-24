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

	private ObservableList<MessageGui> mensagges;
	private ObservableList<String> items;
	private List<String> users = new ArrayList<String>();
	MessageManager messageManager = MessageManagerFactory.getMessageManager();

	public ChatController() {
		mensagges = FXCollections.observableArrayList();
		items = FXCollections.observableArrayList(users);
		// mensagges.addListener(new ListChangeListener<MessageGui>() {
		//
		// public void onChanged(ListChangeListener.Change<? extends MessageGui>
		// chance) {
		//
		// }
		// });
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		lvMensajes.setItems(mensagges);
		lvUser.setItems(items);

		lvMensajes.setCellFactory(new Callback<ListView<MessageGui>, ListCell<MessageGui>>() {
			@Override
			public ListCell<MessageGui> call(ListView<MessageGui> param) {
				return new ItemFormat();
			}

		});

	}

	@FXML
	public void sendMensaje() {

		if (!taMensaje.getText().trim().equals("")) {
			int indice = lvUser.getSelectionModel().getSelectedIndex();
			MessageGui mensaje;
			if (indice >= 0) {
				String nombre = lvUser.getSelectionModel().getSelectedItem();
				mensaje = new MessageGui(taMensaje.getText(), messageManager.whoIAm(), nombre);
			} else {

				mensaje = new MessageGui(taMensaje.getText(), messageManager.whoIAm());

			}
			addMessage(mensaje);
			taMensaje.setText("");
			messageManager.sendMessage(mensaje);
		}
	}

	@FXML
	public void desselectUser() {
		lvUser.getSelectionModel().clearSelection();
	}

	public void setUserList(List<String> userlist) {
		items.clear();
		items.addAll(userlist);
	}

	public void addMessage(MessageGui message) {
		mensagges.add(message);
	}

}
