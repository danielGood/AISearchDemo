package hPath;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class IDA<T> {
        //interface
	    //tempNextthreshold
	    //path       
	    //costthreshold
	     //notsolved    
	    //initial node
       //solution node
	  // curr node     - stored in recurr
	
	private T initialNode;
	private T solutionNode;
	private boolean notSolved;
	
	
	private childRules<T> cR;
	private Vector<T> path = new Vector<T>(0);
	
	
	IDA(T initialNode, T solutionNode, childRules<T> cR){
		notSolved=true;
		this.initialNode=initialNode;
		this.solutionNode=solutionNode;
		this.cR=cR;
		
		
	    		
	}
	
	public void algo(){
		int cost =h(initialNode);
		while(notSolved){
			//System.out.println(cost);
			int temp =deepFirst(initialNode, 0, cost);
			cost=temp;
			//System.out.println(nextCost);          //  -- currently always 0
			
		}
		toPrint();
		
		
	}
	//likewise the currNode should be thought of as a parent
	//g is the previous g not the new g
	private int deepFirst(T currNode, int g, int cost){
		
		
		if(notSolved){
			if(currNode.equals(solutionNode))
				notSolved=false;
			//System.out.println(cR.toString(currNode));
			//System.out.println(g);
			int k =cR.h(currNode);
			int f=k+g;
			if(f>cost)
				return f;
			

			//g=cR.g(currNode, )+g;
			//
			Vector<T> children = new Vector<T>(0);
			children=cR.getChildren(currNode);
			int min=999999;
			Iterator id = children.iterator();
			while(id.hasNext()){
				
				T child = (T) id.next();
				int temp = deepFirst(child, g+cR.g(currNode, child), cost);
				if (temp<min)
					min=temp;
			}
			
			return min;
			
		}else{
			path.add(currNode);
		}
		return 9876543;
		
	}
	
	public void debug(){
		int cost =h(initialNode);
		deepFirst(initialNode, 0, cost);
		
	}
	public void toPrint(){
		
		for(T child: path){
			System.out.println(cR.toString(child));
		
		}
	}
	
	
	
     private  int h(T myT){
    	
		   return cR.h(myT);
	   }
	  
	    
	
}
