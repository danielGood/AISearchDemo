package simplesearch;

import java.util.Iterator;
import java.util.Vector;

public class Minimax<T, E>  {
        
	T gameboard;
	int maxDepth;
	private TreeSearch<T, E> ts;
	private T last;
	
	Minimax(T board, TreeSearch<T, E> ts){
        	this.gameboard=board;
        	maxDepth=5;
        	this.ts=ts;
        }
	
	
	
	T Algo(){
		Max(gameboard, maxDepth);
		return ts.clone(last);
	}
	
	T Max(T gameboard, int depth){
		if(depth==0 || ts.isLeaf(gameboard)){
			
			return gameboard;
			
		}
		depth--;
		Vector<T> children = ts.getChildren(gameboard);
		Iterator<T> id = children.iterator();
		T bestChild=null;
		T recordChild=null;
		int best =-1000;
		while(id.hasNext()){
			T child = id.next();
			T future = Min(child, depth);
			if(ts.h(child)>best){
				bestChild=future;
				child=recordChild;
			}
			
		}
		
		last=recordChild;
		
		
		return bestChild;
	}
	
	
	
	T Min(T gameboard, int depth){
		if(depth==0 || ts.isLeaf(gameboard)){
			
			return gameboard;
			
		}
		depth--;
		Vector<T> children = ts.getChildren(gameboard);
		Iterator<T> id = children.iterator();
		T bestChild=null;
		T recordChild=null;
		int best =1000;
		while(id.hasNext()){
			T child = id.next();
			T future = Max(child, depth);
			if(ts.h(child)<best){
				bestChild=future;
				child=recordChild;
			}
			
		}
		
		last=recordChild;
		
		
		return bestChild;
	}
}
