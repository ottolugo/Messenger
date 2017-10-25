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
	ListView<MessageGui> lvMessages;
	@FXML
	TextArea taMessage;
	@FXML
	ListView<String> lvUser;

	private ObservableList<MessageGui> messages;
	private ObservableList<String> items;
	MessageManager messageManager = MessageManagerFactory.getMessageManager();

	public ChatController() {
		messages = FXCollections.observableArrayList();
		items = FXCollections.observableArrayList();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lvMessages.setItems(messages);
		lvUser.setItems(items);

		lvMessages.setCellFactory(new Callback<ListView<MessageGui>, ListCell<MessageGui>>() {
			@Override
			public ListCell<MessageGui> call(ListView<MessageGui> param) {
				return new ItemFormat();
			}

		});

		lvUser.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new UserFormat();
			}

		});
	}

	@FXML
	public void sendMessage() {
		if (!taMessage.getText().trim().equals("")) {
			int index = lvUser.getSelectionModel().getSelectedIndex();
			MessageGui message;
			if (index >= 0) {
				String name = lvUser.getSelectionModel().getSelectedItem();
				message = new MessageGui(taMessage.getText(), messageManager.whoIAm(), name);
			} else {
				message = new MessageGui(taMessage.getText(), messageManager.whoIAm());
			}
			addMessage(message);
			taMessage.setText("");
			messageManager.sendMessage(message);
		}
	}

	@FXML
	public void deselectUser() {
		lvUser.getSelectionModel().clearSelection();
	}

	public void setUserList(List<String> userList) {
		ArrayList<String> toErase = new ArrayList<String>();
		for (String item : items) {
			if (!userList.contains(item)) {
				toErase.add(item);
			}
		}
		for (String user : userList) {
			if (!items.contains(user)) {
				items.add(user);
			}
		}
		for (String erase : toErase) {
			items.remove(erase);
		}
	}

	public void addMessage(MessageGui message) {
		messages.add(message);
	}

	public void refreshFormat() {
		lvMessages.refresh();
	}

}
