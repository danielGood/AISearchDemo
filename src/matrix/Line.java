package matrix;

import graph.CartesianPoint;

import java.util.List;
import java.util.Vector;

public class Line {
	
	private List<CartesianPoint> stack = new Vector<>();
	
	Line(){
		
	}
	
	void add(CartesianPoint cp){
	stack.add(cp);
	}
	
	List<CartesianPoint> get(){
		return stack;
	}
}
