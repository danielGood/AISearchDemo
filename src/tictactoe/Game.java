package tictactoe;

import java.util.Iterator;
import java.util.Vector;

public class Game {
	
	private boolean gameOn= true;
	private Vector<String> players= new Vector<String>(0);
	private String currentPlayer ="";
	private int index=0;
	private int numOfPlayers=0;
	Game(){
		
	}
	
	public void setPlayers(Vector<String> players){
		Iterator<String> id =players.iterator();
		while(id.hasNext()){
			String s=id.next();
			this.players.add(s);
		}
		index=0;
		currentPlayer=this.players.get(0);
		this.numOfPlayers=this.players.size();
	}
	
	public void alternatePlayer(){
		if(currentPlayer!=players.lastElement()){
			index++;
		}
		else{
			index=0;
		}
		currentPlayer=players.get(index);
			
	}
	

}
