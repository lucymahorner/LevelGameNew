//Lucy Mahorner and Ethan Bond

package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelEngine {
	
	private int levelNum;
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	private Drawable[] drawablePieces;
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
	
	public void createLevel(int levelNum) {
		this.levelNum = levelNum;
		Bazooka m = new Bazooka('M',20);
		Butler d = new Butler();
		Narwhale u = new Narwhale('U',7);
		Narwhale un = new Narwhale('U',10);
		Winner z = new Winner('Z', 1);
		Shooter s = new Shooter('S', 9);
		Wasp b = new Wasp('B', 12);
		
		switch(levelNum){
		case 1:
			drawablePieces = new Drawable[21];
			movingPieces = new ArrayList<Moveable>();
			movingPieces.add(m);
			movingPieces.add(u);
			movingPieces.add(un);
			drawablePieces[1] = z;
			drawablePieces[9] = s;
			drawablePieces[12] = b;
			break;
		
		case 2:
			drawablePieces = new Drawable[21];
			movingPieces = new ArrayList<Moveable>();
			movingPieces.add(m);
			movingPieces.add(u);
			m.setLocation(10);
			u.setLocation(20);
			z.setLocation(16);
			s.setLocation(8);
			b.setLocation(5);

			drawablePieces[16] = z;
			drawablePieces[8] = s;
			drawablePieces[5] = b;
			break;
		}
		drawablePieces[5] = d;
		interactingPieces.add(u);
		interactingPieces.add(s);
		interactingPieces.add(z);
		interactingPieces.add(b);
		interactingPieces.add(m);
		interactingPieces.add(un);
	}
	
	// request data structures from LevelEngine
	// returns the board and the pieces that show up on the board
	public Drawable [] getBoard(int size) {
		updateBoard();
		return drawablePieces;
	}
	public void updateBoard(){
		for(Moveable piece: movingPieces){
			GamePiece movingPieces = (GamePiece) piece;
			drawablePieces[movingPieces.getLocation()] = piece;
		}
	}
	// returns a list of the Moveable pieces for use outside of the board
	public ArrayList<Moveable> getMovingPieces(){
		return movingPieces;
	}
	
	//returns a list of the GamePiece pieces for use outside of the board
	public ArrayList<GamePiece> getInteractingPieces(){
		return interactingPieces;
	}
	// reset player statistics, starting location determined
	// by level engine
	public int getPlayerStartLoc() {
		return 0;
	}
}