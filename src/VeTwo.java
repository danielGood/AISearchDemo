import java.util.Iterator;
import java.util.Vector;

public class VeTwo {

	public static void main(String[] args) {

		Square mySquare = new Square(3);
		//Square mySquare2 = new Square(3);
		//mySquare2.switchTile(2,1);
		//mySquare.toPrint();
		//mySquare2.toPrint();
		// mySquare.toPrint();
		mySquare.testFunction();
		// mySquare.toPrint();
		// mySquare.switchTile(2, 1);
		// mySquare.toPrint();

		/*
		 * Vector<Square> child = mySquare.generateChildren();//problem in
		 * generate Children Iterator id = child.iterator();
		 * while(id.hasNext()){ Square s= (Square) id.next(); //s.toPrint();
		 * 
		 * }
		 */
		// mySquare.toPrint();
		// squareFunction();
	}// end of main

	static void squareFunction() {

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

		Square mySquare = new Square(3);

		mySquare.assign(assign);// ------------------bug here

		// //////////////////////
		Vector<Object> openList = new Vector<>(0);
		Vector<Object> closedList = new Vector<>(0);
		openList.add(mySquare);

		boolean loop = true;
		while (loop) {
			// ////////////////////////
			Iterator<Object> list = openList.iterator();
			// //////////////// manhan distance
			int low = 100000;
			int lowIndex = -1;
			int index = 0;
			while (list.hasNext()) {
				Square s = (Square) list.next();
				int curr = s.getManDistanceD();
				if (curr < low) {
					low = curr;
					lowIndex = index;
				}
				index++;
			}

			// //////////maintain lists
			Square s = (Square) openList.get(lowIndex);
			boolean goal = s.checkGoal();// check is current node is goal node
			loop = !goal;
			s.toPrint();
			System.out.println();
			if (goal) {
				s.toPrint();
				System.out.println("goal");
				// System.out.println(goal);
			}

			openList.removeElementAt(lowIndex);
			closedList.add(s);
			Vector<Square> child = s.generateChildren();
			Iterator id = child.iterator();
			while (id.hasNext()) {
				Square ss = (Square) id.next();
				ss.toPrint();

			}

			// ////////////////
		}// end of while
	}// end of function

}// end of class

