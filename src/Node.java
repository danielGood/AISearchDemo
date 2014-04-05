import java.util.Iterator;
import java.util.Vector;


public class Node {
     private CartesianPoint cp;
     private Vector<Link> myLinks = new Vector<>(0);
     private int label ;
     
     
     Node(int x, int y, int mylabel){
    	 cp= new CartesianPoint(x, y);
    	 label=mylabel;
     }
     
     
     //a light equals it check only coordinates and not links
     boolean equals(Node n){
    	 boolean de;
    	 de=cp.equals(n.getCartesianPoint());
    	 
    	 return de;
     }
     
     boolean hasLink(Link myLink){
    	 boolean has =false;
    	 
    	 Iterator<Link> l= myLinks.iterator();
 		while(l.hasNext()){
 			Link temp=l.next();
 			if(temp.equals(myLink))
 				has=true;
 		}
 		return has;
 	}
    	 
    	
     
     void toPrint(){
    	 System.out.print(label+ " ");
    	 cp.toPrint();
     }
     
     CartesianPoint getCartesianPoint(){
    	 return cp;
     }
     void setmyLinks(Vector<Link> l){
    	 myLinks=l;
     }
     void addLink(Link l){
    	 myLinks.add(l);
     }
     Vector<Link> getmyLinks(){
    	 return myLinks;
     }
     int getLabel(){
    	return label; 
     }
}
