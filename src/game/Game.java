package game;

import java.util.Vector;

public class Game {
	
	@SuppressWarnings("unused")
	private boolean gameOn= true;
	private Turn turn;
	@SuppressWarnings("unused")
	private Igame igame;
	
	
	Game(Vector<Player> players, Igame conditions){
		turn = new Turn(players);
		igame=conditions;
		
	}
	
	
	public Turn getTurn(){
		return turn;
	}
	
	public void endGame(){
		gameOn=false;
	}
	
	

}
