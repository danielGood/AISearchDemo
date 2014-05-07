package minimax;

import java.util.Iterator;
import java.util.Vector;

import simplesearch.TreeSearch;

public class Minimax<T, E>  {
        
	T gameboard;
	int maxDepth;
	private TreeSearch<T, E> ts;
	private T last;
	
	public Minimax(T board, TreeSearch<T, E> ts){
        	this.gameboard=board;
        	maxDepth=5;
        	this.ts=ts;
        }
	
	
	
	public T Algo(){
		Max(gameboard, maxDepth);
		
		return ts.clone(last);
	}
	
	T Max(T gameboard, int depth){
		
		if(depth==0 || ts.isLeaf(gameboard)){
			
			return gameboard;
			
		}
		depth--;
		ts.setTurn("max");
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
				recordChild=child;
				
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
		ts.setTurn("min");
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
				recordChild=child;
			}
			
		}
		
		last=recordChild;
		
		
		return bestChild;
	}
}
