package hPath;


public class Position {
   
	Tile originalTile;
	Tile currTile;
	int index;
	int x;
	int y;
	Position(Tile t, int myX, int myY){
	   originalTile=t;
	   currTile=t;
	   x=myX;
	   y=myY;
   }
	
	Position(Tile t, Tile o, int myX, int myY){
		   originalTile=o;
		   currTile=t;
		   x=myX;
		   y=myY;
		   
	   }
	void setTile(Tile t){
		currTile=t;
	}
	
   Tile getTile(){
		return currTile;
	}
   
   Tile getoriginalTile(){
		return originalTile;
	}
   
   //returns manhatten distance for current tile to return to current position
   int getManhanttenDistance(){
	  int iX= currTile.getinitX();
	  int iY= currTile.getinitY();
	  int distance =0;
	  distance = Math.abs(x - iX) + Math.abs(y - iY) ;
	  return distance;
   }
   
   int getX(){
	   return x;
   }
   int getY(){
	   return y;
   }
}
