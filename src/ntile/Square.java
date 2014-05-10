package ntile;

import graph.CartesianPoint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import tictactoe.Tile;
import matrix.Cell;
import matrix.ListToMatrix;

//grid coordinates are zero based
public class Square<T> {

	private CartesianPoint blankIndex;
	private HashMap <Tile, CartesianPoint> solu;
	private ListToMatrix<Tile> flux;
	private int length;

	
	//min is always 0
	//max is always length *length
	
	
	
	@SuppressWarnings("unchecked")
	public Square(int myX, List<Tile> tile) {

		length = myX;
		
		
		flux = new ListToMatrix<Tile>((Cell<Tile>) myCell);
		
		
		
		solu=new HashMap<>();
		
		int firstCounter=0;
		for(int i=0; i<myX; i++){
			for(int j=0; j<myX; j++){
				flux.set(j, i, tile.get(firstCounter));
				if(tile.get(firstCounter).getValue()==0)
					blankIndex= new CartesianPoint(j, i);
				firstCounter++;
			}
		}
		
		
		
		
		
		int counter=1;
		for(int i=0; i<myX; i++){
			for(int j=0; j<myX; j++){
				CartesianPoint myCP= new CartesianPoint(i, j);
				Tile t= new Tile(counter);
				solu.put(t, myCP);
				counter++;
			}
		}
		Tile blank = new Tile (0);
		CartesianPoint cpBlank = new CartesianPoint(myX-1, myX-1);
		solu.put(blank, cpBlank);

	}

	Cell<T> myCell = new Cell<T>() {

		@Override
		public String toString(T t) {

			Tile tile = (Tile) t;

			int i = tile.getValue();
			String s = "" + i;
			;
			return s;
		}

	};
	/*
     private CartesianPoint find(int i){
    	 CartesianPoint cp=null;
    	 for(int k=0; k<length; k++){
    		 for(int j=0; j<length; j++){
    			 if(flux.get(k, j).getValue()==0){
    				 cp=new CartesianPoint(k, j);
    			 }
    				 
    		 }
    	 }
    	 return cp;
    	 
     }
     */
	// switch tile with blank tile
	public void switchTile(int myX, int myY) {
		// blank coordinates
		int blankX = blankIndex.getX();
		int blankY = blankIndex.getY();
		// tiles
		Tile blank = flux.get(blankX, blankY);
		Tile swap = flux.get(myX, myY);
		// set tiles up with each others coordinates
		flux.set(myX, myY, blank);
		flux.set(blankX, blankY, swap);

	}

	public String toString() {
		return flux.toString();

	}

	public HashMap<Tile, CartesianPoint> getSolu() {
		return solu;
	}

	public ListToMatrix<Tile> getFlux() {
		return flux;
	}

	public CartesianPoint getBlankIndex() {
		return blankIndex;
	}

	public int getLength() {
		return length;
	}

	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Square))
			return false;
		@SuppressWarnings("unchecked")
		Square<Tile> s = (Square<Tile>) obj;
		if(s.getFlux().equals(this.getFlux()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return getSimpleForm().hashCode();

	}
    
	public Vector<Integer> getSimpleForm() {
		List<Tile> list = flux.getList();
		Vector<Integer> simpleForm = new Vector<Integer>(0);
		Iterator<Tile> e = list.iterator();
		
		while (e.hasNext()) {
			Tile t = e.next();
			
			
			simpleForm.add(t.getValue());
		}

		return simpleForm;
	}
	
	
}
  
