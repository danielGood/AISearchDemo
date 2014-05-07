package graph;

public class CartesianPoint {
     private int x=0;
     private int y=0;
     
    
     
     
     public CartesianPoint(int i, int j){
    	 x=i;
    	 y=j;
     }
     
     
     
     CartesianPoint copy(){
    	 
    	 CartesianPoint cp = new CartesianPoint(x, y); 
    	 return cp;
     }
     
    @Override public boolean equals(Object o){
    	if(!(o instanceof CartesianPoint))
    		return false;
    	CartesianPoint p = (CartesianPoint) o;
    	return p.x==x && p.y==y;
    }
    
    @Override public int hashCode(){
    	int hash=17;
    	hash = 31 * hash + x;
    	hash = 31 * hash + y;
    	return hash;
    }
    
     
     int getManhattenDistance(CartesianPoint cp){
    	 
    	 int distance=0;
    	 distance = Math.abs(x - cp.getX()) + Math.abs(y - cp.getY()) ;
    	 
    	 return distance;
     }
     
     void toPrint(){
    	 System.out.println("x :" +x+" y:"+y);
     }
     
     void setX(int i){
    	 x=i;
     }
     void setY(int i){
    	 y=i;
     }
     public int getX(){
    	 return x;
     }
     public int getY(){
    	 return y;
     } 
     
}
