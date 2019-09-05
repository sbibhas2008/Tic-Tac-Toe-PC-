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
	
	StartScreenController() {
		this.playFirst = false;
	}

    @FXML
    private Button AiBtn;

    @FXML
    private RadioButton mediumBtn;

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
    		game.start(1);
    	}
    	else {
    		game.start(0);
    	}
    }

    @FXML
    void againstPlayer(ActionEvent event) throws IOException {
    	game.start(-1);
    }

    @FXML
    void handleEasyBtn(ActionEvent event) {
    	
    }

    @FXML
    void handleImpossibleBtn(ActionEvent event) {

    }

    @FXML
    void handleMediumBtn(ActionEvent event) {

    }

    @FXML
    void playFirst(ActionEvent event) {
    	playFirst = true;
    }
    
    public void setGameScreen(GameScreen g) {
    	this.game = g;
    }
    

}
