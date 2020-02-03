//Lucy Mahorner and Ethan Bond

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Wasp extends GamePiece {

	Wasp(char symbol, int location){
		super(symbol, location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(getLocation() == playerLocation){
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}