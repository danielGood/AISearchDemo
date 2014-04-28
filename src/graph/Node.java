package graph;


public class Node {
     
     
     private int label ;
     
     Node(){
    	 
     }
     public Node(int mylabel){
    	 
    	 label=mylabel;
     }
     
  
    	 
    	
     
     void toPrint(){
    	 System.out.print(label+ " ");
    	
     }
     
     public String toString(){
    	 String s="";
    	 s=String.valueOf(label);
    	 return s;
     }
 
     int getLabel(){
    	return label; 
     }
     
     public Node clone(){
    	 Node n = new Node(label);
    	 return n;
     }
}
