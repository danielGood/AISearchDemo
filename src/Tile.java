
public class Tile  {
      
	
	  private int x;
      private int y;
      private int initX;
      private int initY;
      private int symbol;
      
	//first time tiles
	Tile(int myX, int myY, int mySymbol){
		x=myX; 
		y=myY;
		initX=myX; 
		initY=myY;
		symbol=mySymbol;
		
	}
	
	Tile(int myX, int myY,int myinitX, int myinitY, int mySymbol){
		x=myX; 
		y=myY;
		initX=myinitX; 
		initY=myinitY;
		symbol=mySymbol;
		
	}
	
	//where l is 2 in a 3X3
	int[][] legalMoves(int l){
		int[][] myMoves =new int[4][2];
		
		
		for(int i=0; i<3;i++){
			for(int j=0; j<2;j++){
			  myMoves[i][j]=-1;	
			}
		}
		
		if(x+1<=l){
			//can move right
			myMoves[0][0]=x+1;
			myMoves[0][1]=y;
		}
		if(x-1>=0){
			//can move left
			myMoves[1][0]=x-1;
			myMoves[1][1]=y;
		}
		
		if(y+1<=l){
			//can move up
			myMoves[2][0]=x;
			myMoves[2][1]=y+1;
		}
		if(y-1>=0){
			//can move down
			myMoves[3][0]=x;
			myMoves[3][1]=y-1;
		}
		return myMoves;
	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	
	int getinitX(){
		return initX;
	}
	int getinitY(){
		return initY;
	}
	int getSymbol(){
		return symbol;
	}
	void setX(int i){
		x=i;
		return ;
	}
	void setSymbol(int i){
		symbol=i;
		return ;
	}
	void setY(int i){
		y=i;
		return ;
	}

}
