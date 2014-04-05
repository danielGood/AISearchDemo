import java.util.Iterator;
import java.util.Vector;


public class Graph {
	private Vector<Node> myNodes = new Vector<>(0);
	private Vector<Link> myLinks = new Vector<>(0);
	private int n;
	private Node curr;
	private Node goalNode;
	
	Graph(){
		int i =9;
		n=i;
		for(int j=0; j<i; j++){
			int x = (int) (Math.random()*10+1);
			int y = (int) (Math.random()*10+1);
			Node n = new Node(x, y, myNodes.size());
			myNodes.add(n);
		}
		curr=myNodes.get(0);
		goalNode=myNodes.get(n-1);
		for(int j=0; j<n-1; j++){
			for(int k=j+1; k<n; k++){
				boolean link =false;
				int chance =(int) (Math.random()*10+1);
				if(chance<4)
					link=true;
				Link temp = new Link(myNodes.get(j), myNodes.get(k));
				if(myNodes.get(j).hasLink(temp))
					link=false;
				if(link){
					myLinks.add(temp);
					myNodes.get(j).addLink(temp); 
					myNodes.get(k).addLink(temp);
				}
			}	
			
		}
		
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
}
