
public class CartesianPoint {
     private int x=0;
     private int y=0;
     
    
     
     
     CartesianPoint(int i, int j){
    	 x=i;
    	 y=j;
     }
     
     
     
     CartesianPoint copy(){
    	 
    	 CartesianPoint cp = new CartesianPoint(x, y); 
    	 return cp;
     }
     
     boolean equals(CartesianPoint cp){
    	 boolean de = false;
    	 if(x==cp.getX()&&y==cp.getY())
    	     de=true;
    	 return de;
    	 
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
     int getX(){
    	 return x;
     }
     int getY(){
    	 return y;
     } 
     
}
