package matrix;

import graph.CartesianPoint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class ListToMatrix<T> {
	
	
	//what is the type
	
	
	
	
	private int numRows;
    private int numCols;
    private Cell<T> data=null;
    
    
    private HashMap<CartesianPoint, T> map = new HashMap<CartesianPoint, T>();
    
    public ListToMatrix(){
    	
    }
    
	public ListToMatrix(HashMap<CartesianPoint, T> map, Cell<T> data){
		
		this.map=map;
		this.data=data;
		
		
	}
	

	
	public ListToMatrix(Vector<T> list, int width, int height){
		
		
		
		numRows=height;
		numCols=width;
		Iterator<T> id=(Iterator<T>) list.iterator();
		
		int w=0;
		int h=0;
		while(id.hasNext()){
			
			T t= id.next();
			
			CartesianPoint p = new CartesianPoint(w, h); 
			map.put(p, t);
			
			
			
			
			if((width-1)>w)
				w++;
			else
			{
				h++;
				w=0;
			}
				
			
		}
		
		
	}
	
	public ListToMatrix(Vector<T> list, int width, int height, Cell<T> data){
		
		this.data=data;
		numRows=height;
		numCols=width;
		
		numRows=height;
		numCols=width;
		Iterator<T> id=(Iterator<T>) list.iterator();
		
		int w=0;
		int h=0;
		while(id.hasNext()){
			
			T t= id.next();
			
			CartesianPoint p = new CartesianPoint(w, h); 
			map.put(p, t);
			
			
			
			
			if(width-1>w)
				w++;
			else
			{
				h++;
				w=0;
			}
				
			
		}
		
		
	}
	
	public T get(int x, int y){
		CartesianPoint p = new CartesianPoint(x, y);
		
		T t=(T) map.get(p);
		
		return t; 
	}
	
	public Vector<T> getCol(int i){
		Vector<T> col = new Vector<T>();
		for(int j=0; j<numRows; j++){
			CartesianPoint p = new CartesianPoint(i, j);
			col.add(map.get(p));
		}
		return col;
		
	}
	
	public Vector<T> getRow(int i){
		Vector<T> col = new Vector<T>();
		for(int j=0; j<numCols; j++){
			CartesianPoint p = new CartesianPoint(j, i);
			//System.out.println(map.get(p));
			if(map.get(p)==null)
				System.out.println("here " + j+ " "+ i);
			col.add(map.get(p));
		}
		
		return col;
		
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
	
	
	 public void set(int x, int y, T t){
		 
		 CartesianPoint p = new CartesianPoint(x, y);
		 map.put(p, t);
	 }
	 
	 public String toString(){
		 
		 String s="";
		 for(int i=0; i<numRows; i++){
			 
			s= s +"\n"+ this.toStringVector(this.getRow(i));
			
		 }
		
		return s;
	 }
	 
	public HashMap<CartesianPoint, T> getMap(){
		
		return map;
	}
	
	public ListToMatrix<T> clone(){
		@SuppressWarnings("unchecked")
		ListToMatrix<T> m= new ListToMatrix<T>((HashMap<CartesianPoint, T>) map.clone(), data);
		
		return m;
	}
	
	public void setCell(Cell<T> data){
		this.data=data;
	}
	
	public Vector<T> getList(){
		Vector<T> a= new Vector<T>();
		for(int i=0; i<numRows; i++){
			a.addAll(this.getRow(i));
			
		}
		
		
		return a;
	}
}
	

