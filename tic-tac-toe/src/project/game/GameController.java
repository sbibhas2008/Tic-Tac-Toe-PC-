package project.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.backend.AIMove;
import project.backend.Game;

public class GameController {

    @FXML
    private GridPane Board;
    
    private Game game;
    
    private Image blank;
    private Image cross;
    private Image circle;
    private Stage stage;
    @FXML
    private Button backBtn;

    
    
    public GameController (Stage stage) {
    	
    	blank = new Image("/blank.png");
    	cross = new Image("/cross.png");
    	circle = new Image("/circle.png");
    	this.stage = stage;
    }

    
    @FXML
    public void initialize() throws IOException {
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0;  j < 3; j++) {
    			ImageView img = new ImageView(blank);
    			img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

    			     @Override
    			     public void handle(MouseEvent event) {
    			    	 try {
							changeImage(event);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
    			     }

					private void changeImage(MouseEvent event) throws IOException {
						ImageView source = (ImageView)event.getSource() ;
    			         Integer colIndex = GridPane.getColumnIndex(source);
    			         Integer rowIndex = GridPane.getRowIndex(source);
    			         ArrayList<Integer> move = game.setMove(colIndex, rowIndex);
    			         if (move.get(2) == 0) {
    			        	 source.setImage(circle);
    			         }
    			         else if (move.get(2) == 1) {
    			        	 source.setImage(cross);
    			         }
    			         
    			         if (game.getAi() != null) {
    			        	 move = game.setMove(0, 0);
        			         if (move.get(2) == 0) {
        			        	 ImageView img = new ImageView(circle);
        			        	 getBoard().add(img, move.get(0), move.get(1));
        			        	 adjustImage(img);
        			         }
        			         else if (move.get(2) == 1) {
        			        	 ImageView img = new ImageView(cross);
        			        	 getBoard().add(img, move.get(0), move.get(1));
        			        	 adjustImage(img);
        			         }
    			         }
    			         int s = game.terminateGame();
    			         if (s != -1) {
    			        	 EndGame.display(s,stage);
    			         }
    			         game.showBoard();
    			         event.consume();
					}

					private void adjustImage(ImageView img) {
						GridPane.setHalignment(img, HPos.CENTER);
						 GridPane.setValignment(img, VPos.CENTER);
					}
    			});
    			GridPane.setHalignment(img, HPos.CENTER); // To align horizontally in the cell
    			GridPane.setValignment(img, VPos.CENTER);
    			this.Board.add(img, i, j);
    			
    		}
    		
    	}
    	if (game.getAi() != null && game.getAIplayer() == 1) {
			ArrayList<Integer> move = game.setMove(0, 0);
			int s = game.terminateGame();
			if (s != -1) {
				EndGame.display(s,stage);
			}
			this.Board.add(new ImageView(cross), move.get(0), move.get(1));
		}
    	 game.showBoard();
    	
    }
    
    @FXML
    void handleBackBtn(ActionEvent event) throws IOException {
    	StartScreen startScreen = new StartScreen(stage);
		GameScreen gameScreen = new GameScreen(stage);
		startScreen.getController().setGameScreen(gameScreen);
		startScreen.start();
    }
    
    public GridPane getBoard() {
    	return this.Board;
    }
    
    public void setMode(int mode) {
    	if (mode == -1) {
    		game = new Game();
    		 EndGame.setMode(mode);
    	}
    	else {
    		game = new Game(mode);
   		 	EndGame.setMode(mode);

    	}
    }
    
    

}