package oesia.formacion.messenger.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oesia.formacion.messenger.P2P.domain.boundaries.GUI.MessageFactory;

/**
 * Hello world!
 *
 */
public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLChat.fxml"));

		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("ITChat");
		// stage.se
		stage.show();
	}

	public static void main(String[] args) {
		MessageFactory.getMessageService().start();
		launch(args);
		// System.out.println("TRP!!!!");
	}
}
