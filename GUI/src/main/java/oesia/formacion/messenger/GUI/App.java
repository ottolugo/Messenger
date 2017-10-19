package oesia.formacion.messenger.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLChat.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("ITChat");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
		// System.out.println("TRP!!!!");
	}
}
