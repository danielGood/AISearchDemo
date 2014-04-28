package matrix;

import java.util.Iterator;
import java.util.Vector;

	public class Column<T> {
	
	private Vector<T> myColumn = new Vector<T>(0);
	Column(Vector column){
		Iterator<T> id=column.iterator();
		while(id.hasNext()){
			T t=id.next();
			myColumn.add(t);
		}
		
	}
	
	
	public Vector<T> getColumn(){
		return myColumn;
	}
	
	T getIndex(int i){
		return myColumn.get(i);
	}
    void setIndex(int i, T t){
    	myColumn.set(i, t);
    }
    
    
    public Column<T> clone(){
    	Vector<T> myC = new Vector<T>(0);
    	Iterator<T> id=myColumn.iterator();
    	while(id.hasNext()){
    		T t=id.next();
    		T s = t;
    		myC.add(s);
    	}
 
    	Column<T> c = new Column<T>(myC);
    	return c;
    }
}
