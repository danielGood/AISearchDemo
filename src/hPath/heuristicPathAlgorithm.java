package hPath;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;


public class heuristicPathAlgorithm<T> {
	
	  
	
	private HashMap<T, T> parent = new HashMap<T, T>();
	private  HashMap<T, Integer> gValues = new HashMap<T, Integer>();
	private  double walkConstant =.5;              //if 1 pure heuristic search, if .5 A*, if 0 uniform cost 
	private Vector<T> openList = new Vector<>(0);
	private Vector<T> closedList = new Vector<>(0);
	private T initalNode;
	private T goalNode;
	
	private childRules<T> cR;
	
	
	
	
	   heuristicPathAlgorithm(){
		   
		   
	   }
	
	    heuristicPathAlgorithm(T initialNode, T goalNode, childRules<T> cR){
		   this.initalNode=initialNode;
		   this.goalNode=goalNode;
		   
		   this.cR=cR;
		   openList.add(initalNode);
		   
		   int g=0;
		   gValues.put(initalNode, g);
		   System.out.println(gValues.get(initialNode));
		  
		   
	   }
	
	
	   
	   
	   
	   
	  
	   
	   
	   
	   void algo(){
		   boolean loop =true;
		   while(loop){
			  // System.out.println(openList.size());
			   if (openList.isEmpty()) {
					System.out.println("Failure: Openlist contains no more nodes");
					loop = false;
				}else{
					T copyNode =  (T) openList.get(0);                 
					T bestNode = cR.clone(copyNode);
					    
					openList.remove(0);//

					closedList.add(bestNode);
					
					if(bestNode.equals(goalNode)){
						loop=false;
						System.out.println("Solution reached");
						printPath(bestNode);
					}else{
						Vector<T> children = new Vector<>(0);
						children=cR.getChildren(bestNode);
						Iterator<T> id = children.iterator();
						
						while(id.hasNext()){
							T child = (T) id.next();
							boolean permission= isNotOnLists(child,openList, closedList);
							
							
							if(permission){
								
									
								int g = (int) gValues.get(bestNode)+cR.g(bestNode, child);
								gValues.put(child, g);
								
								parent.put(child, bestNode);

								double childMan = f(child);
							
								int childIndex=0;
								Iterator<T> addList = openList.iterator();
								while (addList.hasNext()) {
									T out = (T) addList.next();
									
									if(f(out)<childMan){
										
										childIndex++;
									}
								}
								openList.add(childIndex, child);
								
							}
	
						}
					}
			
				}
			   
		   }
		   
	   }
	   
	 
	   
	   
	   
	   
	   
	   
	   
	   
	   void printPath(T bestNode){
		   
		  
		  if(!(parent.get(bestNode)==null)){
			printPath(parent.get(bestNode));  
			
		  }
		  System.out.println(cR.toString(bestNode));
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	    boolean  isNotOnLists(T child, Vector<T>openList, Vector<T>closedList){
			boolean permission=true;
			Iterator<T> innerlist1 = closedList.iterator();
			while (innerlist1.hasNext()) {
				T out =  (T) innerlist1.next();
				if (out.equals(child)){
					permission = false;
					//System.out.println("signal");
				}
					
			}
			
			Iterator<T> innerlist2 = openList.iterator();
			while (innerlist2.hasNext()) {
				T out =  (T) innerlist2.next();
				if (out.equals(child))
					permission = false;
				//System.out.println("signal");
			}
			
			return permission;
		}
	   
	     int h(T myT){
	    	
		   return cR.h(myT);
	   }
	  
	    int g(T myT){
		   
		   return (int) gValues.get(myT);
	   }
	   
	    double f(T myT){
		   
		   return (h(myT)*walkConstant)+(g(myT)*(1-walkConstant));
	   }
	    
	    void setW(int w){
	    	walkConstant=w;
	    }
	    
	    double getW(){
	    	return walkConstant;
	    }
	
}
