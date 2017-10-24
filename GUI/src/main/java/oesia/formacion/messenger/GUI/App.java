package oesia.formacion.messenger.GUI;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
		stage.getIcons().add(new Image(
				"https://pbs.twimg.com/profile_images/3274293417/eb346dec716adff0642b0ea9ed78b8e0_400x400.png"));
		stage.show();

	}

	public void setUserList(List<String> userList) {
		Platform.runLater(() -> {
			cc.setUserList(userList);
		});
	}

	public void addMessage(MessageGui message) {
		Platform.runLater(() -> {
			cc.addMessage(message);
		});
	}

	public static void main(String[] args) {
		Launch.start();
		launch(args);
		System.exit(0);
	}
}
