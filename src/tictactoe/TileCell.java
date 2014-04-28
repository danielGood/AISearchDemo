package tictactoe;

import matrix.Cell;

public class TileCell<T>implements Cell<T> {

	@Override
	public String toString(T t) {
		Tile tile = (Tile) t;
		int i=tile.getValue();
		String s= ""+i;;
		return s;
	}

}
