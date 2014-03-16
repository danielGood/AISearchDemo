import java.util.Iterator;
import java.util.Vector;

//grid coordinates are zero based
public class Square {
	private int blankIndex;
	//private Vector<Tile> myTiles = new Vector<>(0);
	private Vector<Position> myPositions = new Vector<>(0);
	private int size;
	private int x;//max x
	private int y;//max y
    private int length;
    //conversion equations
    //index= length*current y +current x //produces 0,1,2,3,4,5,6,7,8
    //symbol = length*current y+current x + 1 // produces 1,2,3,4,5,6,7,8,9// must make exception for zero
    
    
    
    //symbol to original coordinate equations
    //iY=(symbol-1) % (length);
	//iX=(symbol-iY-1)/(length);
    //
    
    //index to coordinate equations
    //y=((index) % (length));
    //x=(index-y)/(length)
    
    
	// first time square
	Square(int myX) {
		size = myX * myX;
		x = myX - 1;
		y = myX - 1;
		length=myX;
		blankIndex = size - 1;

		for (int i = 0; i < myX; i++) {
			for (int j = 0; j < myX; j++) {
				int symbol = myX * i + j + 1;
				if (i == x && j == y)
					symbol = 0;
				Tile e = new Tile(j, i, symbol);
				//myTiles.add(e);
				Position pos = new Position(e, j, i);
				myPositions.add(pos);
			}
		}

	}

	Square(int myX,Vector<Position> pos, int blank) {
		size = myX * myX;
		x = myX - 1;
		y = myX - 1;
		length=myX;
		blankIndex = blank;
		//myTiles = conTiles;
		myPositions=pos;
		/*
		 * for(int i=0;i<myX;i++){ for(int j=0;j<myX;j++){ //int symbol=
		 * myX*i+j+1; //if(i==2&&j==2) // symbol=0; //Tile e = new Tile(j, i,
		 * symbol); //myTiles.add(e); } }
		 */

	}
	

	boolean checkGoal() {
		boolean i;
		int distance= this.getManDistanceD();
		if(distance==0){
			i=true;
		}
		else
			i=false;

		return i;
	}

	Vector<Square> generateChildren() {
		Position pos = myPositions.get(blankIndex);
		Tile e = pos.getTile();
		int[][] moves = e.legalMoves(x);

		
		Vector<Square> children = new Vector<>(0);
		
		
		for (int i = 0; i < 4; i++) {
			if (moves[i][0] != -1) {
				
				
				

				
				//Square tempSqr = new Square(x + 1, tiles,myPositions, blankIndex);
				Square tempSqr =new Square(length);
				tempSqr = this.copy();
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
		//System.out.println("out of loop");

		// children.get(0).toPrint();
		// children.get(1).toPrint();
		// create vector tile copies
		// perform switches
		// init Squares
		// return Squares
		return children;
	}

	public void switchTile(int myX, int myY) {
		Iterator<Position> e = myPositions.iterator();
		int counter = 0;
       
		while (e.hasNext()) {
			Position pos = e.next();
            Tile t =pos.getTile();
			
			
			if (myX == pos.getX() && myY == pos.getY()) {
				
				
				Position blank = myPositions.get(blankIndex);
				Tile tBlank=blank.getTile();
				
				
				blank.setTile(t);
				pos.setTile(tBlank);
				
				
				myPositions.set(counter, pos);
				myPositions.set(blankIndex, blank);
				
				blankIndex=counter;
				

			}
			counter++;
		}

	}

	void toPrint() {

		Iterator<Position> e = myPositions.iterator();
		int counter = 0;
		
     
		
		while (e.hasNext()) {
			
			Position pos = e.next();
			Tile t = pos.getTile();
			
			
			
			int symbol = t.getSymbol();
			System.out.print(symbol + "  ");
			
			
			if((counter % length)==(length-1))
				System.out.println();
			
			counter++;
		}
		
		System.out.println();
		
		
	
		System.out.println();
		
	}

	
	void debugOutput(){
		Iterator<Position> e = myPositions.iterator();
		
		
     int counter=0;

		while (e.hasNext()) {
			
			Position pos = e.next();
			Tile o=pos.getoriginalTile();
			Tile t = pos.getTile();
			
			int symbol = t.getSymbol();
			
			System.out.println("Position :" + counter);
			System.out.println("Current Tile Stats");
			System.out.println(t.getX()+"  "+ t.getY() +" "+ t.getSymbol());
			System.out.println(t.getinitX() + " "+ t.getinitY());
			System.out.println("Original Tile Stats");
			System.out.println(o.getX()+"  "+ o.getY() +" "+ o.getSymbol());
			System.out.println(o.getinitX() + " "+ o.getinitY());
			System.out.println("----------------------------------------------");
			
			
			counter++;
		}
	}
	
	int getManDistanceD() {
		int distance = 0;
		Iterator<Position> e = myPositions.iterator();

		while (e.hasNext()) {
			Position pos = e.next();
			
			//System.out.println(t.getX()+"  "+ t.getY() +" "+ t.getSymbol());
			//System.out.println(t.getinitX() + " "+ t.getinitY());
			
			distance = pos.getManhanttenDistance() + distance;
		}
		
		return distance;
	}

	Square assign(int symbols[]) {
		
		
		//i=(x+1)*y+x
		//given i index 
		//size 
		//myX
	    int myBlank=blankIndex;
		Vector<Position> pos = new Vector<>(size);
		int myX= x+1;		
		
		Iterator<Position> e = myPositions.iterator();
       int counter=0;
		while (e.hasNext()) {
			Position p =e.next();
			Tile t = p.getTile();
			
			//symbol to original tile square
			int iY=(symbols[counter]-1) % (length);
			int iX=(symbols[counter]-1-iY) / (length);
			
			Tile myT = new Tile(p.getX(),p.getY(),iX, iY, symbols[counter]);
			p.setTile(myT);
			pos.add(p);
			counter++;
		}

		
		Square tempSqr = new Square(x + 1, pos, myBlank);
		return tempSqr;
		

		
	}

	void testFunction() {
		//switchTile(2,2);
		
		
	}
	
	Square copy(){
		Vector<Position> positions = new Vector<>(0);
		Iterator<Position> e = myPositions.iterator();
        int counter=0;
        int myX;
        int myY;
		while (e.hasNext()) {
			Position pos=e.next();//current position
			
			Tile t = pos.getTile();
			Tile o = pos.getoriginalTile();
			
			Tile myT = new Tile(t.getX(),t.getY(),t.getinitX(),t.getinitY(),t.getSymbol());
			Tile myO = new Tile(o.getX(),o.getY(),o.getinitX(),o.getinitY(),o.getSymbol());
			myY=counter %length;
			myX=(counter-myY)/length;
			Position addPos = new Position(myT, myO, myX, myY );
			
			positions.add(addPos);
			counter++;
		}
		Square tempSqr = new Square(x + 1,positions, blankIndex);
		return tempSqr;
		
	}
	
	boolean equals(Square mySquare){
		boolean test = true;
		
		Iterator<Position> e = myPositions.iterator();
		
		Vector<Position> pos = mySquare.getmyPositions();
		
		Iterator<Position> f = pos.iterator();
		while (e.hasNext()) {
			Position posOne=e.next();
			Position posTwo = f.next();
			
			Tile t = posOne.getTile();
			Tile s =posTwo.getTile();
			
			//Tile myT = new Tile(t.getX(),t.getY(),t.getinitX(),t.getinitY(),t.getSymbol());
			if(!(       t.getX()==s.getX()   &&     t.getY()==s.getY()   &&  t.getinitX()==s.getinitX()   &&   t.getinitY()==s.getinitY()  &&   t.getSymbol()==s.getSymbol()       )){
				test=false;
			}
			
		}
		
		
		return test;
	}
	
	Vector<Position> getmyPositions(){
		return myPositions;
	}

}
