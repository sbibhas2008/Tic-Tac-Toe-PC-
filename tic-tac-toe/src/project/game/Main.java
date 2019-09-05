package project.game;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
		
	@Override
	public void start(Stage primaryStage) {
		try {
			StartScreen startScreen = new StartScreen(primaryStage);
			GameScreen gameScreen = new GameScreen(primaryStage);
			startScreen.getController().setGameScreen(gameScreen);
			startScreen.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
