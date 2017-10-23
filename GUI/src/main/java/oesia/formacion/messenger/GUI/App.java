package oesia.formacion.messenger.GUI;

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

    private static ChatController cc = new ChatController();
    private static App app;

    public static App getApp() {
	return app;
    }

    @Override
    public void start(Stage stage) throws Exception {
	app = this;
	Parent root = FXMLLoader.load(getClass().getResource("FXMLChat.fxml"));

	Scene scene = new Scene(root);
	// scene.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
	stage.setScene(scene);
	stage.setTitle("ITChat");
	// stage.getIcons()
	stage.show();

    }

    public void setUserList(List<String> userList) {
	if (cc == null) {
	    cc = new ChatController();
	}
	cc.setUserList(userList);

    }

    public void addMessage(MessageGui message) {
	if (cc == null) {
	    cc = new ChatController();
	}
	cc.addMessage(message);
    }

    public static void main(String[] args) {
	Launch.start();
	launch(args);
	// System.out.println("TRP!!!!");

	System.exit(0);

    }

    public ChatController getChatController() {
	return cc;
    }
}
