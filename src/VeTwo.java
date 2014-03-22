import java.util.Iterator;
import java.util.Vector;

public class VeTwo {

	
	
	/*
	 * 
	 * 
An inversion is when a tile precedes another tile with a lower number on it. The solution state has zero inversions. For example, if, in a 4 x 4 grid, number 12 is top left, then there will be 11 inversions from this tile, as numbers 1-11 come after it. To explain it another way, an inversion is a pair of tiles (a,b) such that a appears before b, but a>b. Count the number of inversions in the grid. For example, on the grid of fig.4:
the 12 gives us 11 inversions
the 1 gives us none
the 10 gives us 8 inversions
the 2 gives us none
the 7 gives us 4 inversions
the 11 gives us 6 inversions
the 4 gives us one inversion
the  14 gives us 6
the 5 gives us one
the 9 gives us 3
the 15 gives us 4
the 8 gives us 2
2 from the 13
one from the 6
So there are 49 inversions in this example.

The formula says:
If the grid width is odd, then the number of inversions in a solvable situation is even.
If the grid width is even, and the blank is on an even row counting from the bottom (second-last, fourth-last etc), then the number of inversions in a solvable situation is odd.
If the grid width is even, and the blank is on an odd row counting from the bottom (last, third-last, fifth-last etc) then the number of inversions in a solvable situation is even.
That gives us this formula for determining solvability:
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	public static void main(String[] args) {

		//Daniel Good
		//Currently Star runs a pure heuristic/best first search algorithm on a eight square puzzle
		//child loop bracket
		
		
		//mySquare2.switchTile(1, 2);
		//mySquare2.switchTile(0, 2);
		
		
		//mySquare2.toPrint();
		//mySquare2.debugOutput();
		star();
	}// end of main

	
	
	//right now this is the pure heuristic search
	static void star(){
		//1
		
			
		Vector<Object> openList = new Vector<>(0);
		Vector<Object> closedList = new Vector<>(0);
			
		Square mySquare = new Square(3);

		mySquare=assign();
		
		openList.add(mySquare);// maintain openList as a priority queue with the
								// lowest values first
		//int firstH = mySquare.getManDistanceD();
		//int firstF = firstH + 0;
		// 2
		boolean loop = true;
		while (loop) {
			if (openList.isEmpty()) {
				System.out.println("Failure: Openlist contains no more nodes");
				loop = false;
			} else {
				Square copyNode = (Square) openList.get(0);
				Square bestNode = new Square(3);
				bestNode = copyNode.copy();
				
              // bestNode.toPrint();
				openList.remove(0);//

				closedList.add(bestNode);
				//System.out.println(closedList.size() + "  " + openList.size());
				if (bestNode.checkGoal()) {
					loop = false;
					System.out.println("Solution reached");
					//bestNode.getParent().toPrint();
					printSolution(bestNode);
					//bestNode.toPrint();
				} else {
					Vector<Square> children = new Vector<>(0);
					children = bestNode.generateChildren();

					Iterator id = children.iterator();
					while (id.hasNext()) {
						Square child = (Square) id.next();

						
						
						boolean permission= isNotOnLists(child,openList, closedList);

						if (permission){
							
							addParent(child, bestNode);
							
							
							int childMan = child.getManDistanceD();
							
							int childIndex=0;
							Iterator<Object> addList = openList.iterator();
							while (addList.hasNext()) {
								Square out = (Square) addList.next();
								if(out.getManDistanceD()<childMan){
									childIndex++;
								}
							}
							
							openList.add(childIndex, child);
						}
							
					}//child loop bracket
					
					

				}
				
			}
			
		}
		
		
		
		
	}
	
	
	static Square assign(){
		int symbols[] =new int[9];
		///  0   1   2
		///  3   4   5
		///  6   7   8
		
		
		symbols[0]=4;//
		symbols[1]=1;//
		symbols[2]=3;//
		
		symbols[3]=0;//
		symbols[4]=2;//
		symbols[5]=6;//
		
		symbols[6]=7;//
		symbols[7]=5;//
		symbols[8]=8;//
		
		Square mySquare = new Square(3);

		mySquare=mySquare.assign(symbols);
		
		return mySquare;
	}
	
	
	
	static boolean isNotOnLists(Square child, Vector<Object>openList, Vector<Object>closedList){
		boolean permission=true;
		Iterator<Object> innerlist1 = closedList.iterator();
		while (innerlist1.hasNext()) {
			Square out = (Square) innerlist1.next();
			if (out.equals(child)){
				permission = false;
				//System.out.println("signal");
			}
				
		}
		
		Iterator<Object> innerlist2 = openList.iterator();
		while (innerlist2.hasNext()) {
			Square out = (Square) innerlist2.next();
			if (out.equals(child))
				permission = false;
			//System.out.println("signal");
		}
		
		return permission;
	}
	
   static void addParent(Square child, Square parent){
	  
	   if(child.getParent()==null)
	   {   
		  
	       child.setParent(parent);    
	      
	   }
	
	   
	   else
	   {
		   Square former = child.getParent();
		   int f=former.getManDistanceD();
		   int p= parent.getManDistanceD();
		   if(p<f)
			   child.setParent(parent);
	   }
	   
	   
   }
   
   static void printSolution(Square finalNode){
	  // finalNode.toPrint();
	   Vector<Square> mySquare = new Vector<>(0);
	   Square curr = finalNode;
	   Square parent;
	   boolean loop=true;
	   while(loop){
		   //curr.toPrint();
		 // curr.getParent().toPrint();
		   if(!(curr.getParent()==null)){
			   //curr.toPrint();
			   mySquare.add(curr);
			   curr=curr.getParent();
			   
		   }
		   else{
			   //curr.toPrint();
			   mySquare.add(curr);
			   
			   loop=false;
		   }
		   
		  
		   
	   }
	   
	   int size= mySquare.size()-1;
		  
	   for(int i=size; i>=0; i--){
		   Square temp= mySquare.get(i);
		   
		   temp.toPrint();
	   }
	   
	   
	 
   }
   
   
}// end of class




/*
3/20 current bug path finding, tends to skip over some steps, however all steps are accurate - not yet fixed
  3/21 fixed was a copy bug, copy gave it same parents, - so there are two general types of copies those with parents and those without (ironicly children)
anyways this is easily fixed in generateChildren with setParents(null)
*/