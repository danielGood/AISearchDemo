import java.util.Iterator;
import java.util.Vector;

public class VeTwo {

	public static void main(String[] args) {

		//Daniel Good
		//Currently Star runs a pure heuristic/best first search algorithm on a eight square puzzle
		Square mySquare = new Square(3);
		int symbols[] =new int[9];
		symbols[0]=8;
		symbols[1]=6;
		symbols[2]=7;
		symbols[3]=3;
		symbols[4]=5;
		symbols[5]=4;
		symbols[6]=1;
		symbols[7]=0;
		symbols[8]=2;
		
		Square mySquare2 = new Square(3);
		
		//mySquare2=mySquare.assign(symbols);
		//mySquare2.toPrint();
		//mySquare2.toPrint();
		//mySquare2.testFunction();
		//mySquare2.debugOutput();
		//mySquare2.switchTile(1, 2);
		
		
		
		
		
		//mySquare2.toPrint();
		//mySquare2.debugOutput();
		star();
	}// end of main

	
	
	
	static void star(){
		//1
			int symbols[] =new int[9];
			symbols[0]=8;
			symbols[1]=6;
			symbols[2]=7;
			symbols[3]=3;
			symbols[4]=5;
			symbols[5]=4;
			symbols[6]=1;
			symbols[7]=0;
			symbols[8]=2;
			
			Vector<Object> openList = new Vector<>(0);
			Vector<Object> closedList = new Vector<>(0);
			
			Square mySquare = new Square(3);

		mySquare=mySquare.assign(symbols);
		
		openList.add(mySquare);// maintain openList as a priority queue with the
								// lowest values first
		int firstH = mySquare.getManDistanceD();
		int firstF = firstH + 0;
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
               //bestNode.toPrint();
				openList.remove(0);//

				closedList.add(bestNode);
				if (bestNode.checkGoal()) {
					loop = false;
					System.out.println("Solution reached");
					bestNode.toPrint();
				} else {
					Vector<Square> children = new Vector<>(0);
					children = bestNode.generateChildren();

					Iterator id = children.iterator();
					while (id.hasNext()) {
						Square child = (Square) id.next();

						
						boolean permission = true;
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
						}

						if (permission){
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
		
		
		
		// 1
		// 2
		// 3
		// 4
		// 5
	}

}// end of class

