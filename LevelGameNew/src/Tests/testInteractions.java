//Lucy Mahorner and Ethan Bond
package Tests;
import levelPieces.*;
import gameEngine.*;

import org.junit.Test;

import java.util.*;

public class testInteractions {
	@Test
	public void testNarwhaleInteraction(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Player p = new Player(0);
		Narwhale whale = new Narwhale('N', 19);
		gameBoard[19] = whale;
		gameBoard[0] = p;
		InteractionResult reaches =InteractionResult.NONE;		
		for(int i = 0; i < 200; i++){
			double random = Math.random();
			int randInt = (int) (random*20 +1);
			whale.move(gameBoard, randInt);
			if(randInt == p.getLocation()){
				reaches = whale.interact(gameBoard, randInt);
				break;
			}
		}
		assert(reaches.equals(InteractionResult.ADVANCE));
}
	@Test
	public void testWinnerInteraction(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Player p = new Player(0);
		Winner nextLevel = new Winner('W', 15);
		gameBoard[15] = nextLevel;
		gameBoard[0] = p;
		InteractionResult reaches = InteractionResult.NONE;		
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++){
			p.doMove(gameBoard);
			if(nextLevel.getLocation() == p.getLocation()){
				reaches = nextLevel.interact(gameBoard, p.getLocation());
				break;
			}
		}
		assert(reaches.equals(InteractionResult.GET_POINT));
}
}
