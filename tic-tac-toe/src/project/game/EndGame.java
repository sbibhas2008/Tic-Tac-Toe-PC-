package project.game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EndGame {
	
	public static void display(int status) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Game Over");
		window.setMinWidth(250);
		
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
		// closes for now;
		restart.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(l, restart);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
