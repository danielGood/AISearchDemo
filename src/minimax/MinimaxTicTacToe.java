package minimax;

import java.util.Iterator;
import java.util.Vector;

import matrix.ListToMatrix;
import simplesearch.TreeSearch;
import tictactoe.TicTacToeBoard;
import tictactoe.Tile;

public class MinimaxTicTacToe<T, E> implements TreeSearch<T, E> {

	
	private int turn =1;
	@Override
	public Vector<T> getChildren(T myNode) {
		
		TicTacToeBoard<T> tictac =  (TicTacToeBoard<T>) myNode;
		
		ListToMatrix<T> matrix = tictac.getMatrix();
		Vector<TicTacToeBoard<T>> boards=new Vector<TicTacToeBoard<T>>(0);
    	
		
		
    	Iterator<Tile>id = (Iterator<Tile>) matrix.getList().iterator();
    	int xcounter=0;
    	int ycounter=0;
    	while(id.hasNext()){
    		Tile t= id.next();
    		
    		if(t.getValue()==-1){
    			///create children
    			//make clone
    			//add symbol to eligible clone
    			//add clone to vector
    			
    			
    			
    			ListToMatrix<T> matrix2 =matrix.clone();
    			
    			if(xcounter==2){
    				xcounter=0;
    				ycounter++;
    			}
    			Tile e = new Tile(turn);
    			matrix2.set(xcounter, ycounter, (T) e);
    			TicTacToeBoard<T> board = new TicTacToeBoard<T>(matrix2);

    			
    			boards.add(board);
    		}
    		
    		
    		xcounter++;
    	}
    	
    	
    	
    	return (Vector<T>) boards;
		
	}

	@Override
	public int h(T myNode) {
		TicTacToeBoard<T> tictac =  (TicTacToeBoard<T>) myNode;
		
		ListToMatrix<T> matrix = tictac.getMatrix();
		
		int h = 0;
		
		Vector<Tile> line = new Vector<Tile>(0);
		boolean check;
		check = tictac.compareTilesForH((Vector<Tile>) matrix.getRow(0));
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getRow(1));
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getRow(2));
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getCol(0));
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getCol(1));
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getCol(2));

		line.add((Tile) matrix.get(0, 0));
		line.add((Tile) matrix.get(1, 1));
		line.add((Tile) matrix.get(2, 2));
		check = tictac.compareTilesForH(line);
		if (check)
			h++;

		line.set(0, (Tile) matrix.get(0, 2));
		line.set(1, (Tile) matrix.get(1, 1));
		line.set(2, (Tile) matrix.get(2, 0));
		check = tictac.compareTilesForH(line);
		if (check)
			h++;

		

		return h;
		
	}

	@Override
	public int g(T parent, T child) {
		//g is unused 
		return 0;
	}

	@Override
	public T clone(T myNode) {

		TicTacToeBoard<T> tictac =  (TicTacToeBoard<T>) myNode;
	
		ListToMatrix<T> matrix = tictac.getMatrix();
		
		TicTacToeBoard<T> tictactoe = new TicTacToeBoard<T>(matrix.clone());
		return (T) tictactoe;
	}

	@Override
	public String toString(T myNode) {
		TicTacToeBoard<T> tictac =  (TicTacToeBoard<T>) myNode;
		
		ListToMatrix<T> matrix = tictac.getMatrix();
		String s= matrix.toString();
    	
		  
    	return s;
		
	}

	@Override
	public boolean isLeaf(T myNode) {
		TicTacToeBoard<T> tictac =  (TicTacToeBoard<T>) myNode;
		
		ListToMatrix<T> matrix = tictac.getMatrix();
		boolean bo = true;
    	
    	Iterator<Tile>id = (Iterator<Tile>) matrix.getList().iterator();
    	while(id.hasNext()){
    		Tile t=id.next();
    		if(t.getValue()==-1)
    			bo=false;
    	}
    	
    	if(tictac.checkSolved())
    		bo=true;
    	
		
		
		
		return bo;
	}

	@Override
	public boolean isRoot(T myNode) {
		// isRoot is unused
		return false;
	}

	@Override
	public E NodeValue(T myNode) {
		//this only applies for primitive types
		return null;
	}
	
	public void setTurn(String turn){
		
		if (turn=="max")
			this.turn=1;
		else
			this.turn=0;
	}
	

}
