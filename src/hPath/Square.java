package hPath;
import java.util.Iterator;
import java.util.Vector;

//grid coordinates are zero based
public class  Square {
	private int blankIndex;
	//private Vector<Tile> myTiles = new Vector<>(0);
	private Vector<Position> myPositions = new Vector<>(0);
	private static int size;
	private static int x;//max x
	private static int y;//max y
    private static int length;
    //private Square parent=null;
    //private int fDash=0;
   // private int gDash =0;
   // private int hDash =0;
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
    
    public Square() {
		
		blankIndex = size - 1;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				int symbol = length * i + j + 1;
				if (i == x && j == y)
					symbol = 0;
				Tile e = new Tile(j, i, symbol);
				//myTiles.add(e);
				Position pos = new Position(e, j, i);
				myPositions.add(pos);
			}
		}

	}
    
    
	public Square(int myX) {
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
	

	public boolean checkGoal() {
		boolean i;
		int distance= this.getManDistanceD();
		if(distance==0){
			i=true;
		}
		else
			i=false;

		return i;
	}

	public Vector<Square> generateChildren() {
		Position pos = myPositions.get(blankIndex);
		//System.out.println(blankIndex);
		Tile e = pos.getTile();
		e.setX(pos.getX());
		e.setY(pos.getY());
		int[][] moves = e.legalMoves(x);

		
		Vector<Square> children = new Vector<>(0);
		
		
		for (int i = 0; i < 4; i++) {
			if (moves[i][0] != -1) {
				
				
				//System.out.println(moves[i][0]+" "+moves[i][1]);

				
				//Square tempSqr = new Square(x + 1, tiles,myPositions, blankIndex);
				Square tempSqr =new Square(length);
				
				tempSqr = this.childCopy();
				//tempSqr.setParent(null);//don't copy parents
				// this.toPrint();
				// tempSqr.toPrint();
				//tempSqr.debugOutput();
				tempSqr.switchTile(moves[i][0], moves[i][1]);// switch is
																// editing
																// parent nodes
				 
				// tempSqr.toPrint();
				children.add(tempSqr);
				// System.out.println(moves[i][0]+ " "+ moves[i][1]);
				// System.out.println(i);
				// ///////////////

			}
		}
	
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
				
				
				tBlank.setX(myX);
				tBlank.setY(myY);
				
				t.setX(pos.getX());
				t.setY(pos.getY());
				
				blank.setTile(t);
				pos.setTile(tBlank);
				
				
				myPositions.set(counter, pos);
				myPositions.set(blankIndex, blank);
				
				blankIndex=counter;
				//this.debugOutput();

			}
			counter++;
		}
          //System.out.println(blankIndex);
	}

	public void toPrint() {

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

	
	public void debugOutput(){
		Iterator<Position> e = myPositions.iterator();
		
		
     int counter=0;

		while (e.hasNext()) {
			
			Position pos = e.next();
			Tile o=pos.getoriginalTile();
			Tile t = pos.getTile();
			
			int symbol = t.getSymbol();
			
			System.out.println("Position :" + counter);
			System.out.println(pos.getX()+" "+pos.getY());
			System.out.println("Current Tile Stats");
			System.out.println("X:"+t.getX()+"  Y:"+ t.getY() +"  Symbol:"+ t.getSymbol());
			System.out.println("ix:"+t.getinitX() + "  iy:"+ t.getinitY());
			System.out.println("Original Tile Stats");
			System.out.println("x: "+o.getX()+"  y:"+ o.getY() +" symbol"+ o.getSymbol());
			System.out.println("ix:"+o.getinitX() + "  iy:"+ o.getinitY());
			System.out.println("----------------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			counter++;
		}
	}
	
	public int getManDistanceD() {
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

	public Square assign(int symbols[]) {
		
		
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
			int iX=(symbols[counter]-1) % (length);
			int iY=(symbols[counter]-1-iX) / (length);
			if(symbols[counter]==0){
				iX=2;
				iY=2;
				myBlank=counter;
			}
				
			Tile myT = new Tile(p.getX(),p.getY(),iX, iY, symbols[counter]);
			p.setTile(myT);
			pos.add(p);
			counter++;
		}

		
		Square tempSqr = new Square(x + 1, pos, myBlank);
		return tempSqr;
		

		
	}

	public void testFunction() {
		//switchTile(2,2);
		
		
	}
	
	public Object clone(){
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
			//System.out.println(counter + " "+ myX+  " "+ myY);
			Position addPos = new Position(myT, myO, myY, myX );
			
			positions.add(addPos);
			counter++;
		}
		Square tempSqr = new Square(x + 1,positions, blankIndex);
		//tempSqr.setParent(this.parent);
		//tempSqr.setfDash(fDash);
		//tempSqr.setgDash(gDash);
		//tempSqr.sethDash(hDash);
		return tempSqr;
		
	}
	
	public Square childCopy(){
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
			//System.out.println(counter + " "+ myX+  " "+ myY);
			Position addPos = new Position(myT, myO, myY, myX );
			
			positions.add(addPos);
			counter++;
		}
		Square tempSqr = new Square(x + 1,positions, blankIndex);
		
		return tempSqr;
		
	}	
	
	
	public boolean equals(Object mySquare){
		boolean test = true;
		
		Iterator<Position> e = myPositions.iterator();
		
		Vector<Position> pos = ((Square) mySquare).getmyPositions();
		
		Iterator<Position> f = pos.iterator();
		while (e.hasNext()) {
			Position posOne=e.next();
			Position posTwo = f.next();
			
			Tile t = posOne.getTile();
			Tile s =posTwo.getTile();
			
			//each position carrys the x an y coordinates so there is no need to check for them
			if(!(t.getSymbol()==s.getSymbol()))
				test=false;
			
		}
		//System.out.println("mark");
		return test;
	}
	
	public Vector<Position> getmyPositions(){
		return myPositions;
	}
	public void setParent(Square s){
		//parent=s;
	}
	
    
	public int getBlankIndex(){
		return blankIndex;
	}
	public int getLength(){
		return length;
	}
	
	@Override
	public int hashCode(){
		return getSimpleForm().hashCode();
		
	}
	
	public Vector<Integer> getSimpleForm(){
		Vector <Integer> simpleForm = new Vector<Integer>(0);
		Iterator<Position> e = myPositions.iterator();
		while (e.hasNext()) {
			Position pos=e.next();
			Tile t=pos.getTile();
			simpleForm.add(t.getSymbol());
		}
		
		return simpleForm;
	}
}

/*3/19 encountered error with Manhattan values, the error was traced to assign(), I did two things to fix it 
 * I created an exception for the zero symbol and I also inverted ix and iy.  The initals symptoms of this error were duplicate values in the bestNodes.  I also cleaned up equals for 
 * the position paradigm.
 * 
 * 
 *3/20 made some modifications to prepare for pathtracking and long story short, I think the 8 is acting as the 0; 
 * 
 * 
 * 
 * 
 * 
 */
 
  
