package hPath;

import java.util.Iterator;
import java.util.Vector;

public class OperatorSquare<T> implements childRules<T> {
        
	
	    OperatorSquare(){
        	
        }
        
	    public String toString(T myNode){
	    	Square mySquare = (Square) myNode;
	    	Vector<Integer>simple =mySquare.getSimpleForm();
	    	String s= simple.toString();
	    	return s;
	    }
	    
	    @SuppressWarnings("unchecked")
		public T clone(T myNode){
			
	    	
	    	Square mySquare = (Square) myNode;
	    	///////////////////
	    	Vector<Position> firstPos;
	    	int length=mySquare.getLength();
	    	int blankIndex=mySquare.getBlankIndex();
	    	int x=length-1;
	    	firstPos=mySquare.getmyPositions();
	    	
	    	
	    	Vector<Position> positions = new Vector<>(0);
			Iterator<Position> e = firstPos.iterator();
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
	    	
	    	
	    	 
	    	
	    	
	    	
	    	return (T) tempSqr ;
	 
	    }
	    
	    public int g(T parent, T child){
	     return 1;	
	    }
         @SuppressWarnings("unchecked")
		public Vector<T> getChildren(T myNode){
        	Square mySquare = (Square) myNode;
        	Vector<Square> myChildren = new Vector<>(0);
        	Vector<T> myC = new Vector<>(0);
        	
        	int blankIndex = mySquare.getBlankIndex();
        	int l = mySquare.getLength();
        	
        	//get coordinates of blank
        	//y=((index) % (length));
            //x=(index-y)/(length)
        	//System.out.println(l);
        	//System.out.println(blankIndex);
        	int x=blankIndex%l;
        	int y = (blankIndex-x)/l;
        	//System.out.println(x);
            //System.out.println(y);
        	if(x+1<=l){
    			//can move right
    			myChildren.add(right(x+1, y, mySquare));
    			
    			
    		}
    		if(x-1>=0){
    			//can move left
    			myChildren.add(left(x-1, y, mySquare));
    			
    			
    		}
    		
    		if(y+1<=l){
    			//can move up
    			myChildren.add(up(x, y+1, mySquare));
    			
    			
    		}
    		if(y-1>=0){
    			//can move down
    			myChildren.add(down(x, y-1, mySquare));
    			
    		
    		}
        			
        			myC=(Vector<T>) myChildren;
			return myC;
        }
        
	    
        public int h(T myNode){
			
        	Square mySquare =(Square) myNode;
        	int x=mySquare.getManDistanceD();
        	
        	return x;
        	
        	
        	
        }
        
        Square up(int x, int y, Square mySquare){
        	Square mySquare2 =new Square();
        	mySquare2=(Square) mySquare.clone();
        	mySquare2.switchTile(x, y);
			return mySquare2;
        	
        }
        Square down(int x, int y, Square mySquare){
        	Square mySquare2 =new Square();
        	mySquare2=(Square) mySquare.clone();
        	mySquare2.switchTile(x, y);
			return mySquare2;
        	
        }
        Square left(int x, int y, Square mySquare){
        	Square mySquare2 =new Square();
        	mySquare2=(Square) mySquare.clone();
        	mySquare2.switchTile(x, y);
			return mySquare2;
        	
        }
        Square right(int x, int y, Square mySquare){
        	Square mySquare2 =new Square();
        	mySquare2=(Square) mySquare.clone();
        	mySquare2.switchTile(x, y);
			return mySquare2;
        	
        }

		

		

		
}
