package tictactoe;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import matrix.Cell;
import matrix.ListToMatrix;

public class TicTacToeBoard<T>  {
        
       
        private ListToMatrix<T> matrix ;;
        
      
        public TicTacToeBoard(ListToMatrix<T> matrix){
           this.matrix=matrix;	
        }
       
        
        Cell<T> myCell = new Cell<T>(){

			@Override
			public String toString(T t) {
				
				Tile tile = (Tile) t;
				
				int i=tile.getValue();
				String s= ""+i;;
				return s;
			}
        	
        	
        };
        
       public  boolean checkSolved(){
        	
        	
        	boolean bo=false;
        	boolean check;
        	
        	Vector <Tile> line = new Vector<Tile>(0);
        	       
           check=compareTiles((Vector<Tile>) matrix.getRow(0));
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getRow(1));
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getRow(2));
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getCol(0));
           if(check)
        	   bo=true;
       
           check=compareTiles((Vector<Tile>) matrix.getCol(1));
           if(check)
        	   bo=true;
           
           check=compareTiles((Vector<Tile>) matrix.getCol(2));
           if(check)
        	   bo=true;
           
           line.add((Tile) matrix.get(0,0));
           line.add((Tile) matrix.get(1,1));
           line.add((Tile) matrix.get(2,2));
           check=compareTiles(line);
           if(check)
        	   bo=true;
           
           line.set(0,(Tile) matrix.get(0, 2));
           line.set(1,(Tile) matrix.get(1, 1));
           line.set(2,(Tile) matrix.get(2, 0));
           check=compareTiles(line);
           if(check)
        	   bo=true;
        	
        	return bo;
        }
        
        private boolean compareTiles(Vector<Tile> line){
        	boolean bo= true;
        	int check =-2;
        	Iterator<Tile>id = line.iterator();
        	while(id.hasNext()){
        		Tile t=id.next();
        		if(check==-2)
        			check=t.getValue();
        		if(check!=t.getValue())
        			bo=false;
        		if(check==-1){
        			bo=false;
        		}
        	}
        	
        	return bo;
        }
        
        public boolean compareTilesForH(Vector<Tile> line){
        	boolean bo= false;
        	int numOne =0;
        	int numZ =0;
        	int defaultToken =-1;
        	Iterator<Tile>id = line.iterator();
        	while(id.hasNext()){
        		Tile t=id.next();
        		
        		if(t.getValue()!=defaultToken)
        		{
        			bo=true;
        			
        			if(t.getValue()==1){
        				numOne++;
        			}
        			if(t.getValue()==0){
        				numZ++;
        			}
        		}
        		
        	}
        	
        	if(numZ > 0 && numOne >0){
        		bo=false;
        	}
        	
        	return bo;
        }
        public void move(int x, int y, int value){
        	
        	
        	if(x>2 || y>2 || y<0 || x<0){System.out.println("Out of bouds"); return;}
        		
        	
        	Tile t=(Tile) matrix.get(x, y);
        	int i=t.getValue();
        	if(i==-1)
        		t.setValue(value);
        	else
        	{
        		System.out.println("space already occupied");
        		return;
        	}
        		
            matrix.set(x, y, (T) t);	
        }
        
        
      public ListToMatrix<T> getMatrix(){
    	return matrix;  
      }
        
	@Override
	public String toString(){
		return matrix.toString();
	}
	
	public boolean checkFin() {
		
		
		ListToMatrix<T> matrix = this.getMatrix();
		
		boolean bo = true;
    	
		List<T> v = matrix.getList();
    	Iterator<Tile>id = (Iterator<Tile>) v.iterator();
    	while(id.hasNext()){
    		Tile t=id.next();//error tile is null
    		
    		if(t.getValue()==-1)
    			bo=false;
    	}
    	
    	if(this.checkSolved())
    		bo=true;
    	
		
		
		
		return bo;
	}
	
	
        
}
