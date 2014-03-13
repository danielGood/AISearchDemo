import java.util.Iterator;
import java.util.Vector;

public class VeTwo {

	public static void main(String[] args) {

		//Daniel Good
		//Currently Star runs a pure heuristic/best first search algorithm on a eight square puzzle
		star();
	}// end of main

	
	
	
	static void star(){
		//1
			int[][] assign = new int[9][2];
			assign[0][0] = 0;
			assign[0][1] = 2;
			assign[1][0] = 2;
			assign[1][1] = 2;
			assign[2][0] = 2;
			assign[2][1] = 1;
			assign[3][0] = 1;
			assign[3][1] = 2;
			assign[4][0] = 0;
			assign[4][1] = 0;
			assign[5][0] = 1;
			assign[5][1] = 0;
			assign[6][0] = 2;
			assign[6][1] = 0;
			assign[7][0] = 0;
			assign[7][1] = 1;
			assign[8][0] = 1;
			assign[8][1] = 1;
			Vector<Object> openList = new Vector<>(0);
			Vector<Object> closedList = new Vector<>(0);
			
			Square mySquare = new Square(3);

		mySquare.assign(assign);// ------------------bug here
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
               // bestNode.toPrint();
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

