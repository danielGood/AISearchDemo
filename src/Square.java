import java.util.Iterator;
import java.util.Vector;

//grid coordinates are zero based
public class Square {
	private int blankIndex;
	private Vector<Tile> myTiles = new Vector<>(0);
	private int size;
	private int x;
	private int y;

	// first time square
	Square(int myX) {
		size = myX * myX;
		x = myX - 1;
		y = myX - 1;
		blankIndex = size - 1;

		for (int i = 0; i < myX; i++) {
			for (int j = 0; j < myX; j++) {
				int symbol = myX * i + j + 1;
				if (i == 2 && j == 2)
					symbol = 0;
				Tile e = new Tile(j, i, symbol);
				myTiles.add(e);
			}
		}

	}

	Square(int myX, Vector<Tile> conTiles, int blank) {
		size = myX * myX;
		x = myX - 1;
		y = myX - 1;
		blankIndex = blank;
		myTiles = conTiles;
		/*
		 * for(int i=0;i<myX;i++){ for(int j=0;j<myX;j++){ //int symbol=
		 * myX*i+j+1; //if(i==2&&j==2) // symbol=0; //Tile e = new Tile(j, i,
		 * symbol); //myTiles.add(e); } }
		 */

	}

	boolean checkGoal() {
		Iterator<Tile> e = myTiles.iterator();

		boolean i = true;
		while (e.hasNext()) {
			Tile t = e.next();
			int myX = t.getX();
			int myY = t.getY();
			int iX = t.getinitX();
			int iY = t.getinitY();
			if (i && (myX == iX) && (myY == iY))
				i = true;
			else
				i = false;
			// System.out.println(myX + " "+ myY+" "+ t.getSymbol());
			// System.out.println(iX + " "+ iY);
			// System.out.println(i);
		}

		return i;
	}

	Vector<Square> generateChildren() {
		Tile e = myTiles.get(blankIndex);
		int[][] moves = e.legalMoves(x);

		// how many moves
		// Square[] children = new Square[4];
		Vector<Square> children = new Vector<>(0);
		for (int i = 0; i < 4; i++) {
			if (moves[i][0] != -1) {

				Square tempSqr = new Square(x + 1, myTiles, blankIndex);
				// this.toPrint();
				// tempSqr.toPrint();
				tempSqr.switchTile(moves[i][0], moves[i][1]);// switch is
																// editing
																// parent nodes
				// this.toPrint();
				// tempSqr.toPrint();
				children.add(tempSqr);
				// System.out.println(moves[i][0]+ " "+ moves[i][1]);
				// System.out.println(i);
				// ///////////////

			}
		}
		System.out.println("out of loop");

		// children.get(0).toPrint();
		// children.get(1).toPrint();
		// create vector tile copies
		// perform switches
		// init Squares
		// return Squares
		return children;
	}

	public void switchTile(int myX, int myY) {
		Iterator<Tile> e = myTiles.iterator();
		int counter = 0;

		while (e.hasNext()) {
			Tile t = e.next();

			if (myX == t.getX() && myY == t.getY()) {
				Tile blank = myTiles.get(blankIndex);
				int tx = t.getX();
				int ty = t.getY();
				// /////
				int bx = blank.getX();
				int by = blank.getY();
				// /////////
				t.setX(bx);
				t.setY(by);
				blank.setX(tx);
				blank.setY(ty);
				// /////////////
				myTiles.set(counter, t);
				myTiles.set(blankIndex, blank);

			}
			counter++;
		}

	}

	void toPrint() {

		Iterator<Tile> e = myTiles.iterator();
		int counter = 0;
		int[] mySymbols = new int[9];

		// System.out.println(size);
		// System.out.println(x);
		// System.out.println(y);
		// System.out.println(blankIndex);
		while (e.hasNext()) {
			Tile t = e.next();
			// System.out.println(t.getX()+"  "+ t.getY() +" "+ t.getSymbol());
			// System.out.println(t.getinitX() + " "+ t.getinitY());
			int x = t.getX();
			int y = t.getY();
			int symbol = t.getSymbol();
			mySymbols[3 * y + x] = symbol;
			counter++;
		}
		System.out.println(mySymbols[0] + " " + mySymbols[1] + " "
				+ mySymbols[2]);
		System.out.println(mySymbols[3] + " " + mySymbols[4] + " "
				+ mySymbols[5]);
		System.out.println(mySymbols[6] + " " + mySymbols[7] + " "
				+ mySymbols[8]);
		System.out.println();
		System.out.println();
		// Tile t= myTiles.get(blankIndex);
		// System.out.println(t.getSymbol());
	}

	int getManDistanceD() {
		int distance = 0;
		Iterator<Tile> e = myTiles.iterator();

		while (e.hasNext()) {
			Tile t = e.next();
			int myX = t.getX();
			int myY = t.getY();
			int iX = t.getinitX();
			int iY = t.getinitY();
			distance = Math.abs(myX - iX) + Math.abs(myY - iY) + distance;
		}
		return distance;
	}

	void assign(int coord[][]) {
		// dont change the symbol; change x and y
		for (int i = 0; i < 9; i++) {
			Tile t = myTiles.get(i);
			// System.out.println(t.getinitX()+" "+
			// t.getinitY()+" "+t.getSymbol()+ " "+t.getX()+" "+ t.getY());;
			// t.setSymbol(symbols[i]);
			// System.out.println(t.getinitX()+" "+
			// t.getinitY()+" "+t.getSymbol()+ " "+t.getX()+" "+ t.getY());;
			t.setX(coord[i][0]);
			t.setY(coord[i][1]);
			myTiles.set(i, t);

		}
	}

	void testFunction() {
		
		Square tempSqr = new Square(x + 1, myTiles, blankIndex);
		this.toPrint();
		// tempSqr.toPrint();
		tempSqr.switchTile(1, 2);// switch is editing parent nodes
		// tempSqr.toPrint();
		this.toPrint();
	}

}
