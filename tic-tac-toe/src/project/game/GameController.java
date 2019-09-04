package project.game;

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
import project.backend.Game;

public class GameController {

    @FXML
    private GridPane Board;
    
    private Game game;
    
    private Image blank;
    private Image cross;
    private Image circle;
    
    public GameController () {
    	game = new Game();
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
    			         int move = game.setMove(colIndex, rowIndex);
    			         if (move == 0) {
    			        	 source.setImage(circle);
    			         }
    			         else if (move == 1) {
    			        	 source.setImage(cross);
    			         }
    			         System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
    			         event.consume();
					}
    			});
    			GridPane.setHalignment(img, HPos.CENTER); // To align horizontally in the cell
    			GridPane.setValignment(img, VPos.CENTER);
    			this.Board.add(img, i, j);
    		}
    		
    	}
    }
    
    

}