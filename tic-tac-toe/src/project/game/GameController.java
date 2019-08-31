package project.game;

import javafx.fxml.FXML;
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
    
    public GameController () {
    	game = new Game();
    }

    @FXML
    void mouseEntered(MouseEvent e) {
    	 Node source = (Node)e.getSource() ;
         Integer colIndex = GridPane.getColumnIndex(source);
         Integer rowIndex = GridPane.getRowIndex(source);
         System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
    }
    
    @FXML
    public void initialize() {
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0;  j < 3; j++) {
    			ImageView img = new ImageView(new Image("/cross.png"));
    			Board.add(img, i, j, 2, 1);
    		}
    		
    	}
    }

}