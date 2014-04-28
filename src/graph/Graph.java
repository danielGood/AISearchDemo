package graph;
import java.util.Iterator;
import java.util.Vector;


public class Graph {
	private Vector<Node> myNodes = new Vector<>(0);
	private Vector<Link> myLinks = new Vector<>(0);
	private Node currNode;//for graph traversal  //also to represent change of state
	
	
	Graph(){
		addNode();
		currNode=myNodes.get(0);
	}
	void addNode(){
		
		Node a= new Node(myNodes.size());
		myNodes.add(a);
		
	}
	
	void addNode(Node a){
		
		
		myNodes.add(a);
		
	}
	
	//children are nodes, children of currNode
	public Vector<Node> getChildren(){
		 Vector<Node> children = new Vector<>(0);
		 Iterator<Link> l= myLinks.iterator();
			while(l.hasNext()){
				Link temp=l.next();
				if(temp.getM().equals(currNode))
				    children.add(temp.getN());
				if(temp.getN().equals(currNode))
				    children.add(temp.getM());
			}
		return children;
	}
	
	
	public void setCurrNode(Node n){
		currNode=n;
	}
	boolean addConnection(int a, int b, int length){
		boolean check = false;
		if(a<=myNodes.size()&&b<=myNodes.size()){
		Node m = myNodes.get(a);
		Node n = myNodes.get(b);
		Link l = new Link(m, n, length);
		myLinks.add(l);
		check=true;
		}
		
		
		return check;
		
	}
	
	public void addConnection(Link l){
	
		myLinks.add(l);
	
	}
	
	
	void toPrint(){
		System.out.println("Nodes");
		Iterator<Node> i= myNodes.iterator();
		while(i.hasNext()){
			Node n=i.next();
			n.toPrint();
		}
		
		System.out.println("Links");
		Iterator<Link> l= myLinks.iterator();
		while(l.hasNext()){
			Link temp=l.next();
			temp.toPrint();
		}
	}
	
	Vector<Node> getNodes(){
		return myNodes;
	}
	Vector<Link> getLinks(){
		return myLinks;
	}
	public Graph clone(){
		Graph g = new Graph();
		Iterator<Node> nL= myNodes.iterator();
		while(nL.hasNext()){
			Node n=nL.next();
			Node myCopy = n.clone();
			g.addNode(myCopy);
		}
		Iterator<Link> i= myLinks.iterator();
		while(i.hasNext()){
			Link myLink=i.next();
			Link myCopy = myLink.clone();
			g.addConnection(myCopy);
		}
		return g;
	}
}
