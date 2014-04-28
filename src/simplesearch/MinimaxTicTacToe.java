package simplesearch;

import java.util.Iterator;
import java.util.Vector;

import matrix.ListToMatrix;
import tictactoe.TicTacToeBoard;
import tictactoe.Tile;

public class MinimaxTicTacToe<T, E> implements TreeSearch<T, E> {

	
	private int turn =1;
	@Override
	public Vector<T> getChildren(T myNode) {
		
		TicTacToeBoard<T> tictac =  (TicTacToeBoard<T>) myNode;
		
		ListToMatrix<T> matrix = tictac.getMatrix();
		Vector<TicTacToeBoard> boards=new Vector<TicTacToeBoard>(0);
    	
    	Iterator<Tile>id = (Iterator<Tile>) matrix.getAll().iterator();
    	int counter=0;
    	while(id.hasNext()){
    		Tile t= id.next();
    		System.out.println(t.getValue());
    		if(t.getValue()==-1){
    			///create children
    			//make clone
    			//add symbol to eligible clone
    			//add clone to vector
    			System.out.println("mark");
    			
    			Vector<T> all =(Vector<T>) matrix.getAll().clone();
    			Tile s = new Tile(turn);
    			all.set(counter, (T) s);
    			TicTacToeBoard<T> board = new TicTacToeBoard<T>((Vector<Tile>) all);

    			
    			boards.add(board);
    		}
    		
    		
    		counter++;
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
		check = tictac.compareTilesForH((Vector<Tile>) matrix.getRow(0).getColumn());
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getRow(1).getColumn());
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getRow(2).getColumn());
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getColumn(0).getColumn());
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getColumn(1).getColumn());
		if (check)
			h++;

		check = tictac.compareTilesForH((Vector<Tile>) matrix.getColumn(2).getColumn());

		line.add((Tile) matrix.getIndex(0, 0));
		line.add((Tile) matrix.getIndex(1, 1));
		line.add((Tile) matrix.getIndex(2, 2));
		check = tictac.compareTilesForH(line);
		if (check)
			h++;

		line.set(0, (Tile) matrix.getIndex(0, 2));
		line.set(1, (Tile) matrix.getIndex(1, 1));
		line.set(2, (Tile) matrix.getIndex(2, 0));
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
		ListToMatrix<T> matrix2 = matrix.clone();
		Vector<T> all=matrix2.getAll();
		TicTacToeBoard<T> tictactoe = new TicTacToeBoard<T>((Vector<Tile>) all);
		return null;
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
    	
    	Iterator<Tile>id = (Iterator<Tile>) matrix.getAll().iterator();
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
	
	public void setTurn(int turn){
		this.turn=turn;
	}
	

}
