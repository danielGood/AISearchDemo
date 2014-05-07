package game;

import java.util.Vector;

public class Turn {
		private Vector<Player> players = new Vector<Player>(0);
		private int currPlayer;
		
		
		Turn(Vector<Player> players){
			this.players=players;
		}
		
		void rotate(){
			if(players.size()>=currPlayer)
				currPlayer=0;
			else
				currPlayer++;
		}
		
		String getCurrPlayer(){
			return players.get(currPlayer).getName();
		}
}
