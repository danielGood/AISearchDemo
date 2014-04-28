package graph;

import java.util.Iterator;
import java.util.Vector;

import hPath.childRules;

public class SearchMethods<T> implements childRules<T>  {
	
	
	SearchMethods(){
		
	}
	
	
	public String toString(T myNode){
		
		
		
		
		
		return null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public T clone (T myNode){
		
		
		Graph g = new Graph();
		Graph h = (Graph) myNode;
		Vector<Link> linkList =h.getLinks();
		Vector<Node> nodeList =h.getNodes();
		
		Iterator<Node> nL= nodeList.iterator();
		while(nL.hasNext()){
			Node n=nL.next();
			Node myCopy = n.clone();
			g.addNode(myCopy);
		}
		Iterator<Link> i= linkList.iterator();
		while(i.hasNext()){
			Link myLink=i.next();
			Link myCopy = myLink.clone();
			g.addConnection(myCopy);
		}
		
		
		
		
		return (T) g;
		
	}
	//don't get confused t is graph
	//in this it will be path of current node of parent to child
	public int g(T parent, T child){
		return 0;
	     	
	}
	
	@SuppressWarnings("unchecked")
	public Vector<T> getChildren(T myNode){
		Vector<Node> children = new Vector<>(0);
		Vector<Graph> childGraph = new Vector<>(0);
		
		
		Graph myCast = (Graph) myNode;
		children=myCast.getChildren();
		Iterator<Node> i= children.iterator();
		while(i.hasNext()){
			Node node=i.next();
		    Graph myCopy = myCast.clone();
		    myCopy.setCurrNode(node);
		    childGraph.add(myCopy);
		}
		
		return (Vector<T>) childGraph;
		
	}
	
	public int h(T myNode){
		return 0;
		
	}
}
