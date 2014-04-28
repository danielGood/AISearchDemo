package tictactoe;

import java.util.Iterator;
import java.util.Vector;

import matrix.Cell;
import matrix.ListToMatrix;

public class TicTacToeBoard<T>  {
        
       
        private ListToMatrix<T> matrix ;;
        
        TicTacToeBoard(){
        	
        	Vector<Tile> myTiles = new Vector<Tile>(0);
        	
        	for(int i=0; i<9;i++){
  
        			Tile myTile = new Tile();
        			myTiles.add(myTile);
        		
        	}
        	Cell<T> myCell = new TileCell();
        	matrix= new ListToMatrix<T>((Vector<T>) myTiles, 3, 3, myCell);
        }
        
        public TicTacToeBoard(Vector<Tile> myTiles ){
        	
        	matrix= new ListToMatrix<T>((Vector<T>) myTiles, 3, 3);
        }
        
        
        
       
        
       public  boolean checkSolved(){
        	
        	
        	boolean bo=false;
        	boolean check;
        	
        	Vector <Tile> line = new Vector<Tile>(0);
        	       
           check=compareTiles((Vector<Tile>) matrix.getRow(0).getColumn());
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getRow(1).getColumn());
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getRow(2).getColumn());
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getColumn(0).getColumn());
           if(check)
        	   bo=true;
       
           check=compareTiles((Vector<Tile>) matrix.getColumn(1).getColumn());
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getColumn(2).getColumn());
           if(check)
        	   bo=true;
           
           line.add((Tile) matrix.getIndex(0,0));
           line.add((Tile) matrix.getIndex(1,1));
           line.add((Tile) matrix.getIndex(2,2));
           check=compareTiles(line);
           if(check)
        	   bo=true;
           
           line.set(0,(Tile) matrix.getIndex(0, 2));
           line.set(1,(Tile) matrix.getIndex(1, 1));
           line.set(2,(Tile) matrix.getIndex(2, 0));
           check=compareTiles(line);
           if(check)
        	   bo=true;
        	
        	return bo;
        }
        
        private boolean compareTiles(Vector<Tile> line){
        	boolean bo= true;
        	int check =-2;
        	Iterator<Tile>id = line.iterator();
        	while(id.hasNext()){
        		Tile t=id.next();
        		if(check==-2)
        			check=t.getValue();
        		if(check!=t.getValue())
        			bo=false;
        		if(check==-1){
        			bo=false;
        		}
        	}
        	
        	return bo;
        }
        
        public boolean compareTilesForH(Vector<Tile> line){
        	boolean bo= false;
        	int numOne =0;
        	int numZ =0;
        	int defaultToken =-1;
        	Iterator<Tile>id = line.iterator();
        	while(id.hasNext()){
        		Tile t=id.next();
        		
        		if(t.getValue()!=defaultToken)
        		{
        			bo=true;
        			
        			if(t.getValue()==1){
        				numOne++;
        			}
        			if(t.getValue()==0){
        				numZ++;
        			}
        		}
        		
        	}
        	
        	if(numZ > 0 && numOne >0){
        		bo=false;
        	}
        	
        	return bo;
        }
        public void move(int x, int y, int value){
        	
        	Tile t=(Tile) matrix.getIndex(x, y);
        	t.setValue(value);
            matrix.setIndex(x, y, (T) t);	
        }
        
        
      public ListToMatrix<T> getMatrix(){
    	return matrix;  
      }
        
	@Override
	public
        String toString(){
		return matrix.toString();
	}
	
	
	
        
}
