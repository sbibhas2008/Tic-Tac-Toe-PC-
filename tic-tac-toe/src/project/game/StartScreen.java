package project.game;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartScreen {

	private Stage stage;
	private String title;
	private StartScreenController controller;
	private Scene scene;
	
	public StartScreen (Stage s) throws IOException {
		this.stage = s;
		this.title = "Tic Tac Toe";
		controller = new StartScreenController();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
		loader.setController(controller);
		
		Parent root = loader.load();
		scene = new Scene(root);
	}
	
	public void start() {
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}
	
	public StartScreenController getController() {
		return controller;
	}
}
