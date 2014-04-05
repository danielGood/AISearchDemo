package hPath;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;


public class heuristicPathAlgorithm<T> {
	
	  
	
	private HashMap<T, T> parent = new HashMap<T, T>();
	private  HashMap<T, Object> gValues = new HashMap<T, Object>();
	private  double walkConstant =0.5;              //if 1 pure heuristic search, if .5 A*, if 0 uniform cost 
	private Vector<T> openList = new Vector<>(0);
	private Vector<T> closedList = new Vector<>(0);
	private T initalNode;
	private T goalNode;
	private String className;
	private childRules<T> cR;
	
	
	
	
	   heuristicPathAlgorithm(){
		   
		   
	   }
	
	    heuristicPathAlgorithm(T initialNode, T goalNode, String clName, childRules<T> cR){
		   this.initalNode=initialNode;
		   this.goalNode=goalNode;
		   className=clName;
		   this.cR=cR;
		   openList.add(initialNode);
		   
		   int g=0;
		   gValues.put(initialNode, g);
		  
		   
	   }
	
	
	   
	   T reflectCon(){
		  try {
			Class cl = Class.forName(className);
			Constructor con =cl.getConstructor();
			Object mySquare = (Object) con.newInstance();
			return (T) mySquare;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return null;
	   }
	   
	   
	   
	   
	  
	   
	   
	   
	   void algo(){
		   boolean loop =true;
		   while(loop){
			  // System.out.println(openList.size());
			   if (openList.isEmpty()) {
					System.out.println("Failure: Openlist contains no more nodes");
					loop = false;
				}else{
					T copyNode =  (T) openList.get(0);                 //square specific
					T bestNode = reflectCon();
					bestNode = cR.clone(copyNode);      
					                                 //square specific
					
	            ///  System.out.println(cR.toString(bestNode));
					openList.remove(0);//

					closedList.add(bestNode);
					
					if(bestNode.equals(goalNode)){
						loop=false;
						System.out.println("Solution reached");
						printPath(bestNode);
					}else{
						Vector<T> children = new Vector<>(0);
						children=cR.getChildren(bestNode);
						Iterator id = children.iterator();
						
						while(id.hasNext()){
							T child = (T) id.next();
							boolean permission= isNotOnLists(child,openList, closedList);
							
							//System.out.println(permission);
							if(permission){
								
								int g = (int) gValues.get(bestNode)+cR.g(bestNode, child);
								gValues.put(child, g);
								
								parent.put(child, bestNode);
								
								
								double childMan = f(child);
								//System.out.println(childMan);
								int childIndex=0;
								Iterator<T> addList = openList.iterator();
								while (addList.hasNext()) {
									T out = (T) addList.next();
									//System.out.println(childMan);
									//System.out.println(f(out));
									if(f(out)<childMan){
										//System.out.println("hello");
										childIndex++;
									}
								}
								//System.out.println(openList.size());
								//System.out.println(childIndex);
								openList.add(childIndex, child);
								//System.out.println(openList.size());
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
