package matrix;

import graph.CartesianPoint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

public class ListToMatrix<T> {
	
	
	//what is the type
	
	
	
	
	
    private Cell<T> data=null;
    
    
    private HashMap<CartesianPoint, T> map = new HashMap<CartesianPoint, T>();
    private List<Line> xTrack = new Vector<Line>();
    private List<Line> yTrack = new Vector<Line>();
    
    public ListToMatrix(){
    }
    
	public ListToMatrix(HashMap<CartesianPoint, T> map, Cell<T> data){
		this.map=map;
		this.data=data;	
	}
	

	public ListToMatrix(Cell<T> data){
		this.data=data;
	}
	
	public T get(int x, int y){
		CartesianPoint p = new CartesianPoint(x, y);
		
		T t=(T) map.get(p);
		if(t==null){
			System.out.println("t is null at get x= "+x+" y="+y);
		}
		return t; 
	}
	
	public List<T> getCol(int i){
		
		//col null exception
		//in other words there isn't a line class there
		
		List<T> ts = new Vector<T>();
		List<CartesianPoint> cp=xTrack.get(i).get();
		Iterator<CartesianPoint> id=cp.iterator();
		while(id.hasNext()){
			CartesianPoint myCp= id.next();
			ts.add(map.get(myCp));
			
		}
		
		return ts;
		
	}
	
	public List<T> getRow(int i){
		
		//row null exception
		List<T> ts = new Vector<T>();
		List<CartesianPoint> cp=yTrack.get(i).get();
		Iterator<CartesianPoint> id=cp.iterator();
		while(id.hasNext()){
			CartesianPoint myCp= id.next();
			ts.add(map.get(myCp));
			
		}
		
		return ts;
		
	}
	
	
	String toStringVector(List<CartesianPoint> temp){
		String s="";
		Iterator<CartesianPoint> id= (Iterator<CartesianPoint>) temp.iterator();
		while(id.hasNext()){
			CartesianPoint cp=id.next();
			T t=map.get(cp);
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
		 while(x>=xTrack.size())
			 xTrack.add(new Line());
		 while(y>=yTrack.size())
			 yTrack.add(new Line());
		 if(!(map.containsKey(new CartesianPoint(x, y)))){
		      xTrack.get(x).add(new CartesianPoint(x, y));
		 	  yTrack.get(y).add(new CartesianPoint(x, y));
		 }
		 map.put(p, t);
		 //negative exception
		 //cannot accept negative cp
		
	 }
	 
	 public String toString(){
		 
		 String s="";
		 Iterator<Line> id =yTrack.iterator();
			while(id.hasNext()){
				///size matrix line=0 exception
				Line l= id.next();
				List<CartesianPoint> list=l.get();
				
				s=s+toStringVector(list)+"\n";
			}
		
		return s;
	 }
	 
	public HashMap<CartesianPoint, T> getMap(){
		
		return map;
	}
	
	public ListToMatrix<T> copy(){
		
		
		ListToMatrix<T> m= new ListToMatrix<T>(data);
		Iterator<Entry<CartesianPoint, T>> id =map.entrySet().iterator();
		while(id.hasNext()){
			Entry<CartesianPoint, T> cp= id.next();
			m.set(cp.getKey().getX(), cp.getKey().getY(), cp.getValue());
			//System.out.println(cp.getKey().getX()+" "+ cp.getKey().getY()+" "+data.toString(cp.getValue()));
		}
		
		
			
		return m;
	}
	
	public void setCell(Cell<T> data){
		this.data=data;
	}
	
	public List<T> getList(){
		 List<T> t = new Vector<>(0);
		 Iterator<Line> id =yTrack.iterator();
			while(id.hasNext()){
				///size matrix line=0 exception
				Line l= id.next();
				List<CartesianPoint> list=l.get();
				Iterator<CartesianPoint> id2 =list.iterator();
				while(id2.hasNext()){
					t.add(map.get(id2.next()));
				}
				
			}
		
		return t;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof ListToMatrix))
			return false;
		@SuppressWarnings("unchecked")
		ListToMatrix<T> m =  (ListToMatrix<T>) obj;
	
		return m.getMap().equals(map);
	}
	
	@Override
	public int hashCode(){
		return map.hashCode();
	}
}
	

