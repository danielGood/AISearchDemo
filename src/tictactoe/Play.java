package tictactoe;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Play<T> {

	
	private static Scanner scanner = new Scanner( System.in );
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          TicTacToeBoard<?>  t= new TicTacToeBoard();
          
          System.out.println(t.toString());
          
          Vector v =t.getMatrix().getAll();
          System.out.println(v.size());
          
          
          
	}
	
	
	
	
	
	
	static TicTacToeBoard playerTurn(TicTacToeBoard t){
		//System.out.print(t.toString());
		
		int playerTurn=0;
		int inputX;
        int inputY;
        
        
        System.out.println("x coord");
  	    inputX=scanner.nextInt();
  	    System.out.println("y coord");
  	    inputY=scanner.nextInt();
  	    
  	     t.move(inputX, inputY, playerTurn);
  	    
  	    //System.out.print(t.toString());
  	    
  	    return t;
		
	}
	
	
	
	
	
	
	
	
	static int alternateplayer(int i){
		if(i==1)
			return 0;
		else
			return 1;
		
	}

}
