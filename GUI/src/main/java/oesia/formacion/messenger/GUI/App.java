package oesia.formacion.messenger.GUI;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oesia.formacion.messenger.GUI.entities.MessageGui;

/**
 * Hello world!
 *
 */
public class App extends Application {

	private ChatController cc;
	private static App app;

	public static App getApp() {
		return app;
	}

	@Override
	public void start(Stage stage) throws Exception {
		app = this;
		Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("FXMLChat.fxml"));
			root = loader.load();
			cc = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("ITChat");
		// stage.getIcons()
		stage.show();

	}

	public void setUserList(List<String> userList) {
		cc.setUserList(userList);
	}

	public void addMessage(MessageGui message) {
		cc.addMessage(message);
	}

	public static void main(String[] args) {
		Launch.start();
		launch(args);
		System.exit(0);
	}

	public ChatController getChatController() {
		return cc;
	}
}
