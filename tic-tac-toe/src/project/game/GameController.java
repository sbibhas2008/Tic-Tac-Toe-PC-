package project.game;

import java.util.ArrayList;

import javafx.beans.property.Property;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import project.backend.AIMove;
import project.backend.Game;

public class GameController {

    @FXML
    private GridPane Board;
    
    private Game game;
    
    private Image blank;
    private Image cross;
    private Image circle;
    
    public GameController () {
    	
    	blank = new Image("/blank.png");
    	cross = new Image("/cross.png");
    	circle = new Image("/circle.png");
    }

    
    @FXML
    public void initialize() {
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0;  j < 3; j++) {
    			ImageView img = new ImageView(blank);
    			img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

    			     @Override
    			     public void handle(MouseEvent event) {
    			    	 changeImage(event);
    			     }

					private void changeImage(MouseEvent event) {
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
			this.Board.add(new ImageView(cross), move.get(0), move.get(1));
		}
    	 game.showBoard();
    }
    
    public GridPane getBoard() {
    	return this.Board;
    }
    
    public void setMode(int mode) {
    	if (mode == -1) {
    		game = new Game();
    	}
    	else {
    		game = new Game(mode);
    	}
    }
    
    

}