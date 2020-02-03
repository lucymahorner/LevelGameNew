package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.*;
import java.lang.Math;

public class Unicorn extends GamePiece implements Moveable {

	Unicorn(char symbol, int location){
		super(symbol, location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(getLocation() == playerLocation){
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}


	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		System.out.println("Unicorn move fn");
		int loc = getLocation();
		gameBoard[getLocation()] = null;
		do{
			double random = Math.random();
			int randint = (int) (random*20 +1);
			loc = randint;
		} while(gameBoard[loc] != null);
		this.setLocation(loc);
		System.out.println(getLocation());
		gameBoard[getLocation()] = this;
	}
	

}