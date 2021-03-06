//Lucy Mahorner and Ethan Bond

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Shooter extends GamePiece {

	Shooter(char symbol, int location){
		super(symbol, location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(getLocation() == playerLocation){
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}