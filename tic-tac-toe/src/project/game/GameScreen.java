package project.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScreen {

	GameController controller;
	Stage stage;
	
	public GameScreen(Stage stage) {
		this.stage = stage;
		controller = new GameController(stage);
	}
	
	public void start(int mode, String difficulty) throws IOException {
		controller.setMode(mode, difficulty);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
	}
	
	public GameController getController() {
		return this.controller;
	}
}
