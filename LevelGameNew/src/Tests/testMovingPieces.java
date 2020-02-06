//Lucy Mahorner and Ethan Bond
package Tests;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import levelPieces.Bazooka;
import levelPieces.Narwhale;

import org.junit.Test;

public class testMovingPieces {
	@Test
	public void testBazooka(){
		int [] inputs = {7, 8, 9, 20};
		int [] outputs = {8, 9, 10, 19};
		for(int i = 0; i < 4; i++){
			Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			Bazooka weapon = new Bazooka('B', inputs[i]);
			gameBoard[inputs[i]] = weapon;
			weapon.move(gameBoard, inputs[i]);
			assert(weapon.getLocation() == outputs[i]);
		}
		
	}
	@Test
	public void testNarwhale(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Narwhale whale = new Narwhale('N', 19);
		gameBoard[19] = whale;
		Map<Integer, Integer> locations = new HashMap<Integer, Integer>();
		for(int i = 0; i < 200; i++){
			Integer getLoc = whale.getLocation();
			whale.move(gameBoard, getLoc);
			Set<Integer> keys = locations.keySet();
			if(keys.contains(getLoc)){
				int temp = locations.get(getLoc);
				locations.put(getLoc, temp ++);
			}
			else{
				locations.put(getLoc, 1);
			}
		}
		for(int i = 0; i < 10; i++){
			double random = Math.random();
			int randInt = (int) (random*20 +1);
			int newNum = locations.get(randInt);
			assert(newNum > 5);
		}
	}
}
