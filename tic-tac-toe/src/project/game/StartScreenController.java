package project.game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

public class StartScreenController {
	
	private GameScreen game;
	private boolean playFirst;
	private String difficulty;
	
	StartScreenController() {
		this.playFirst = false;
		this.difficulty = "easy";
	}

    @FXML
    private Button AiBtn;

    @FXML
    private RadioButton impossibleBtn;

    @FXML
    private RadioButton easyBtn;

    @FXML
    private Button playerBtn;

    @FXML
    private ToggleButton toggleBtn;

    @FXML
    void againstAI(ActionEvent event) throws IOException {
    	if (playFirst) {
    		game.start(1, difficulty);
    	}
    	else {
    		game.start(0, difficulty);
    	}
    }

    @FXML
    void againstPlayer(ActionEvent event) throws IOException {
    	game.start(-1, difficulty);
    }

    @FXML
    void handleEasyBtn(ActionEvent event) {
    	this.difficulty = "easy";
    }

    @FXML
    void handleImpossibleBtn(ActionEvent event) {
    	this.difficulty = "impossible";
    }

  
    @FXML
    void playFirst(ActionEvent event) {
    	playFirst = true;
    }
    
    public void setGameScreen(GameScreen g) {
    	this.game = g;
    }
    

}
