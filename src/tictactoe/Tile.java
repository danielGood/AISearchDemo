package tictactoe;

public class Tile  {
       private int value=-1;
       
       Tile(){
    	   
    	   value=-1;
       }
       public Tile(int value){
    	   
    	   this.value=value;
       }
       
       
       
       public int getValue(){
    	   return value;
       }
      void setValue(int value){
    	   this.value=value;
       }
}
