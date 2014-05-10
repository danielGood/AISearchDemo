package ntile;

import graph.CartesianPoint;
import hPath.childRules;

import java.util.HashMap;
import java.util.Vector;

import matrix.ListToMatrix;
import tictactoe.Tile;

public class OperatorSquare<T> implements childRules<T> {
        
	
	    public OperatorSquare(){
        	
        }
        
	    public String toString(T myNode){
	    	@SuppressWarnings("unchecked")
			Square<T> mySquare = (Square<T>) myNode;
	    	
	    	String s= mySquare.toString();
	    	return s;
	    }
	    
	    
		@SuppressWarnings("unchecked")
		public T clone(T myNode){
			
	    	
	    	
			Square<T> mySquare = (Square<T>) myNode;
	    
	    	////////////////////////////////
	    	int length=mySquare.getLength();
	    	////////////////////////////////
	    	ListToMatrix<Tile> flux= mySquare.getFlux();
	    	ListToMatrix<Tile> flux2 =flux.copy();
	    	
	    	/////////////////////////////////////
	    	
			Square<Tile> tempSqr = new Square<Tile>(length, flux2.getList());
			//tempSqr.setParent(this.parent);
			//tempSqr.setfDash(fDash);
			//tempSqr.setgDash(gDash);
			//tempSqr.sethDash(hDash);

	    	return (T) tempSqr ;
	 
	    }
	    
	    public int g(T parent, T child){
	     return 1;	
	    }
         @SuppressWarnings("unchecked")
		public Vector<T> getChildren(T myNode){
        	Square<Tile> mySquare = (Square<Tile>) myNode;
        	Vector<Square<T>> myChildren = new Vector<>(0);
        	Vector<T> myC = new Vector<>(0);
        	
        	CartesianPoint blankCp = mySquare.getBlankIndex();
        	int l = mySquare.getLength();
        	
        	//get coordinates of blank
        	//y=((index) % (length));
            //x=(index-y)/(length)
        	//System.out.println(l);
        	//System.out.println(blankIndex);
        	int x=blankCp.getX();
        	int y = blankCp.getY();
        	//System.out.println(x);
            //System.out.println(y);
        	if(x+1<=l){
    			//can move right
    			myChildren.add(swapTiles(x+1, y, (Square<T>) mySquare));
    			
    			
    		}
    		if(x-1>=0){
    			//can move left
    			myChildren.add(swapTiles(x-1, y, (Square<T>) mySquare));
    			
    			
    		}
    		
    		if(y+1<=l){
    			//can move up
    			myChildren.add(swapTiles(x, y+1, (Square<T>) mySquare));
    			
    			
    		}
    		if(y-1>=0){
    			//can move down
    			myChildren.add(swapTiles(x, y-1, (Square<T>) mySquare));
    			
    		
    		}
        			
        			myC=(Vector<T>) myChildren;
			return myC;
        }
        
	    
        public int h(T myNode){
			
        	@SuppressWarnings("unchecked")
			Square<T> mySquare =(Square<T>) myNode;
        	int x=getManDistanceD(mySquare);
        	
        	return x;
        	
        	
        	
        }
        
        
        
        
        @SuppressWarnings("unchecked")
		Square<T> swapTiles(int x, int y, Square<T> mySquare){
        	
        	Square<T> mySquare2;
			mySquare2 = (Square<T>) clone((T) mySquare);
			mySquare2.switchTile(x, y);
			return mySquare2;
        	
        	
        }
        
        public int getManDistanceD(Square<T> mySquare) {
    		int distance = 0;
    		int l=  mySquare.getLength();
    		ListToMatrix<Tile> matrix = mySquare.getFlux();
    		HashMap<Tile, CartesianPoint> map = mySquare.getSolu();
    		
    		for(int i=0; i<l; i++){
    			for(int j=0; j<l; j++){
    				
    				Tile t = matrix.get(i, j);
    				CartesianPoint secondCP= map.get(t);
    				int x=secondCP.getX();
    				int y=secondCP.getY();
    				distance=distance+(Math.abs(x-i))+(Math.abs(y-j));
    			}
    		}
    		
    		
    		return distance;
    	}
        
    	public boolean checkGoal(Square<T> mySquare) {
    		boolean i;
    		int distance= this.getManDistanceD(mySquare);
    		if(distance==0){
    			i=true;
    		}
    		else
    			i=false;

    		return i;
    	}

		
  
		

		
}
