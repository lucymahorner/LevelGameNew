package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Sniper extends GamePiece {

	Sniper(char symbol, int location){
		super(symbol, location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(getLocation() == playerLocation || getLocation() + 2 == playerLocation 
				|| getLocation() + 1 == playerLocation || getLocation() - 2 == playerLocation
				|| getLocation() - 1 == playerLocation){
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}