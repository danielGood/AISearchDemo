package ntile;

import graph.CartesianPoint;

import java.util.HashMap;
import java.util.Iterator;
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

	@SuppressWarnings("unchecked")
	Square(int myX, Vector<Tile> tile, CartesianPoint cp) {

		length = myX;
		blankIndex = cp;
		
		flux = new ListToMatrix<Tile>(tile, length, length, (Cell<Tile>) myCell);
		
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
	public int hashCode() {
		return getSimpleForm().hashCode();

	}

	public Vector<Integer> getSimpleForm() {
		Vector<Tile> list = flux.getList();
		Vector<Integer> simpleForm = new Vector<Integer>(0);
		Iterator<Tile> e = list.iterator();
		while (e.hasNext()) {
			Tile t = e.next();
			simpleForm.add(t.getValue());
		}

		return simpleForm;
	}
}
  
