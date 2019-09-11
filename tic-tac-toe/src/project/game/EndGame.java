package project.game;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EndGame {
	
	static int mode;
	
	
	public static void display(int status, Stage stage) throws IOException {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Game Over");
		window.setWidth(100);
		window.setHeight(100);
		window.initStyle(StageStyle.UNDECORATED);
		
		String message;
		if (status == 1) {
			message = "X wins";
		} else if (status == 0) {
			message = "O wins";
		} else {
			message = "Draw";
		}
		
		Label l = new Label();
		l.setText(message);
		
		Button restart = new Button("Restart");
	
		restart.setOnAction(e -> {
			window.close();
			GameScreen g = new GameScreen(stage);
			try {
				g.start(mode);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(l, restart);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static void setMode(int m) {
		EndGame.mode = m;
	}
}
