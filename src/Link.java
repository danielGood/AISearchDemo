
public class Link {
 private Node n;
 private Node m;
     
 Link(Node i, Node j){
	 n=i;
	 m=j;
 }
 
 
 
 boolean equals(Link l){
	 boolean de = false;
	 Node i=l.getN();
	 Node j=l.getM();
	 if(i.equals(n)&& j.equals(m))
	     de=true;
	 if(i.equals(m)&& j.equals(n))
	     de=true;
	 return de;
	 
 }
 
 Node getN(){
	return n; 
 }
 Node getM(){
	 return m;
 }
 
 void toPrint(){
	 System.out.println(n.getLabel()+" "+m.getLabel());
 }
 
}
