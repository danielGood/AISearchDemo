package matrix;

import java.util.Iterator;
import java.util.Vector;

import tictactoe.Tile;

public class ListToMatrix<T> {
	
	
	//what is the type
	
	
	private Vector <Column> rows = new Vector <Column>(0);
	private Vector <Column> columns = new Vector <Column>(0);
	private int size;
	private int numRows;
    private int numCols;
    private Cell data=null;
	public ListToMatrix(Vector<T> list){
		
	}
	
	public ListToMatrix(Vector<T> list, int width, int height){
		//exception if list size doesn't == width*height
		
		/*
		
		an example
		
		0  1 2
		3  4 5
		6  7 8
		width=3
		height=3
		
		
		
		
		
	   //0 ,1 ,2 3, 4, 5,... (width-1)
	   //width,             2*width-1
	   //2*width            3*width-1
	    * 
	    * 
	    * 
	    * 
	    * 
	    * 
	    */
		
		//does rows
		numRows=height;
		numCols=width;
		Iterator<T> id=(Iterator<T>) list.iterator();
		//exception id does not have next
		//exception id does not reach all units
		for(int i=0; i<height; i++){
			Vector<T> temp = new Vector<T>(0);
			for(int j=0; j<width; j++){
				T t=id.next();
				temp.add(t);
				
				
			}
			Column<T> c = new Column<T>(temp);
			rows.add(c);
		}
		
		
		//does columns
		for(int j=0; j<width; j++){
			Vector<T> temp = new Vector<T>(0);
			for(int i=0; i<height; i++){
				//pull ith row
				//pull jth unit
				Column<T> r=rows.get(i);
				T t=(T) r.getIndex(j);
				temp.add(t);
				
			}
			Column<T> c = new Column<T>(temp);
			columns.add(c);
		}
		
		
		
	}
	
	public ListToMatrix(Vector<T> list, int width, int height, Cell data){
		//exception if list size doesn't == width*height
		
		/*
		
		an example
		
		0  1 2
		3  4 5
		6  7 8
		width=3
		height=3
		
		
		
		
		
	   //0 ,1 ,2 3, 4, 5,... (width-1)
	   //width,             2*width-1
	   //2*width            3*width-1
	    * 
	    * 
	    * 
	    * 
	    * 
	    * 
	    */
		
		//does rows
		this.data=data;
		numRows=height;
		numCols=width;
		Iterator<T> id=(Iterator<T>) list.iterator();
		//exception id does not have next
		//exception id does not reach all units
		for(int i=0; i<height; i++){
			Vector<T> temp = new Vector<T>(0);
			for(int j=0; j<width; j++){
				T t=id.next();
				temp.add(t);
				
				
			}
			Column<T> c = new Column<T>(temp);
			rows.add(c);
		}
		
		
		//does columns
		for(int j=0; j<width; j++){
			Vector<T> temp = new Vector<T>(0);
			for(int i=0; i<height; i++){
				//pull ith row
				//pull jth unit
				Column<T> r=rows.get(i);
				T t=(T) r.getIndex(j);
				temp.add(t);
				
			}
			Column<T> c = new Column<T>(temp);
			columns.add(c);
		}
		
		
		
	}
	public Column<T> getRow(int i){
		return rows.get(i);
	}
	
	public Column<T> getColumn(int i){
		return columns.get(i);
	}
	
	String toStringVector(Vector<T> temp){
		String s="";
		Iterator<T> id= (Iterator<T>) temp.iterator();
		while(id.hasNext()){
			T t=id.next();
			String y;
			if(data==null)
				y =  t.toString();
			else
				y=data.toString(t);
			
			s = s + " " + y;
		}
		
		return s;
	}
	
	 public T getIndex(int x, int y){
		Column<T> row = rows.get(y);
		return (T) row.getIndex(x);
	}
	 public void setIndex(int x, int y, T t){
		 
		 //rows
		 Column<T> row = rows.get(y);
		 row.setIndex(x, t);
		 rows.set(y, row);
		 
		 //columns
		 Column<T> c = columns.get(x);
		 c.setIndex(y, t);
		 columns.set(x, c);
	 }
	 
	 public String toString(){
		 
		 String s="";
		 for(int i=0; i<numRows; i++){
			s= s +"\n"+ this.toStringVector(this.getRow(i).getColumn());
			
		 }
		 
		 
		return s;
	 }
	 
	public Vector<T> getAll(){
		
		Vector<T> all=new Vector<T>(0);
		Iterator<T> ro = (Iterator<T>) rows.iterator();
		while(ro.hasNext()){
			Column<T> t=  (Column<T>) ro.next();
			Vector<T> v;
			v=t.getColumn();
			Iterator<T> inRow = v.iterator();
			while(inRow.hasNext()){
				T temp = (T) inRow.next();
				all.add(temp);
			}
			
		}
		return all;
	}
	
	public ListToMatrix<T> clone(){
		Vector<T> all= this.getAll();
		Vector<T> all2=(Vector<T>) all.clone();
		ListToMatrix<T> matrix=new ListToMatrix<T>(all2, numCols,numRows);
		return matrix;
	}
}
	

