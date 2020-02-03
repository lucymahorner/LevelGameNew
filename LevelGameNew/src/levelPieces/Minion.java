package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Minion extends GamePiece implements Moveable {

	Minion(char symbol, int location){
		super(symbol, location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(getLocation() == playerLocation || getLocation() + 1 == playerLocation
				|| getLocation() - 1 == playerLocation){
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}


	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[getLocation()] = null;
		int loc;
		if(playerLocation == GameEngine.BOARD_SIZE-1) {
			loc = 20;
			while(gameBoard[loc] != null) {
				loc--;
				
			}
			this.setLocation(loc);
		}
		else {
			loc = playerLocation + 1;
			while(gameBoard[loc] != null) {
				loc++;
				if(loc >= gameBoard.length) {
					loc = playerLocation;
					break;
				}
			}
			this.setLocation(loc);
		}
		gameBoard[getLocation()] = this;
	}

}