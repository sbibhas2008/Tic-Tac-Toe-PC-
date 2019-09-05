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
    	game = new Game(0);
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
    			         move = game.setMove(0, 0);
    			         if (move.get(2) == 0) {
    			        	 getBoard().add(new ImageView(circle), move.get(1), move.get(0));
    			         }
    			         else if (move.get(2) == 1) {
    			        	 getBoard().add(new ImageView(cross), move.get(1), move.get(0));
    			         }
    			         game.showBoard();
    			         event.consume();
					}
    			});
    			GridPane.setHalignment(img, HPos.CENTER); // To align horizontally in the cell
    			GridPane.setValignment(img, VPos.CENTER);
    			this.Board.add(img, i, j);
    			
    		}
    		
    	}
    	if (game.getAi() != null && game.getAIplayer() == 1) {
			ArrayList<Integer> move = game.setMove(0, 0);
			this.Board.add(new ImageView(cross), move.get(1), move.get(0));
		}
    }
    
    public GridPane getBoard() {
    	return this.Board;
    }
    
    

}