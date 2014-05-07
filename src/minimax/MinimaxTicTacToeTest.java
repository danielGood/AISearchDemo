package minimax;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Vector;

import org.junit.Test;

import simplesearch.TreeSearch;
import tictactoe.TicTacToeBoard;

public class MinimaxTicTacToeTest<T, E> {

	@Test
	public void testGetChildren() {
		
		 TreeSearch<T, E> ts = new MinimaxTicTacToe<>();
		 
		// TicTacToeBoard<?>  t= new TicTacToeBoard();
		 Vector<T> v;
		 
		 //v=ts.getChildren((T) t);
		 //System.out.println(v.size());
		 //Iterator<T> id = v.iterator();
		 //while(id.hasNext()){
		//	 T node= id.next();
		//	 System.out.println(ts.toString(node));
			 
		// }
		 
		fail("Not yet implemented");
	}

	@Test
	public void testH() {
		
		TreeSearch<T, E> ts = new MinimaxTicTacToe();
		 
		// TicTacToeBoard<?>  t= new TicTacToeBoard();
		// System.out.println(ts.h((T) t));
		fail("Not yet implemented");
	}



	@Test
	public void testCloneT() {
		TreeSearch<T, E> ts = new MinimaxTicTacToe();
		 
		// TicTacToeBoard<?>  t= new TicTacToeBoard();
		// T tic=ts.clone((T) t);
		 //ts.toString(tic);
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testToStringT() {
		
		TreeSearch<T, E> ts = new MinimaxTicTacToe();
		 
		// TicTacToeBoard<?>  t= new TicTacToeBoard();
		 //System.out.println(ts.toString((T) t));
		 
		fail("Not yet implemented");
	}

	@Test
	public void testIsLeaf() {
		fail("Not yet implemented");
	}

	

	

	@Test
	public void testSetTurn() {
		fail("Not yet implemented");
	}

}
