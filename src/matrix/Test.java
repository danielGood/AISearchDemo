package matrix;

import graph.CartesianPoint;
import graph.Node;

import java.util.Vector;

import tictactoe.Tile;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector myList = new Vector(0);
		
		// 3 7 1
		//11 0 90
		//46 35 80
		
		myList.add(3);
		myList.add(7);
		myList.add(1);
		
		myList.add(11);
		myList.add(0);
		myList.add(90);
		
		myList.add(46);
		myList.add(35);
		
		
		
		
		ListToMatrix matrix = new ListToMatrix(myList, 4, 2);
		
		System.out.println(matrix.get(0, 1));
		System.out.println(matrix.get(1, 1));
		System.out.println(matrix.get(0, 0));
		System.out.println(matrix.get(0, 2));
		System.out.println(matrix.toString());
		
		// 3 7 1 11
		//  0 90 46 35
		
		//myList.add(3);
		//myList.add(7);
		//myList.add(1);
		
		//myList.add(11);
		//myList.add(0);
		//myList.add(90);
		
		//myList.add(46);
		//myList.add(35);
		
		//ListToMatrix matrix2 = new ListToMatrix(myList, 4, 2);
		
		//System.out.println(matrix2.toStringVector(matrix2.getColumn(0).getColumn()));
		//System.out.println(matrix2.toStringVector(matrix2.getColumn(1).getColumn()));
		//System.out.println(matrix2.toStringVector(matrix2.getColumn(2).getColumn()));
		//System.out.println(matrix2.toStringVector(matrix2.getColumn(3).getColumn()));
		//System.out.println(matrix2.toStringVector(matrix2.getRow(0).getColumn()));
		//System.out.println(matrix2.toStringVector(matrix2.getRow(1).getColumn()));
		
		
		
		Vector myList2 = new Vector(0);
		Node a = new Node(5);
		Node b = new Node(8);
		Node c = new Node(7);
		Node d = new Node(9);
		myList2.add(a);
		//myList2.add(b);
		//myList2.add(c);
		//myList2.add(d);
		//ListToMatrix matrix3 = new ListToMatrix(myList2, 2, 2);
		//System.out.println(matrix3.toStringVector(matrix3.getRow(0).getColumn()));
		//System.out.println(matrix3.toStringVector(matrix3.getRow(1).getColumn()));
		//System.out.println(matrix3.toStringVector(matrix3.getColumn(0).getColumn()));
		//System.out.println(matrix3.toStringVector(matrix3.getColumn(1).getColumn()));
		
		//System.out.println(matrix3.getIndex(0, 1).toString());
		//System.out.println(matrix3.getIndex(1, 0).toString());
		Node e = new Node(11);
		//matrix3.setIndex(1, 1, e);
		
		
		//System.out.println(matrix3.toStringVector(matrix3.getRow(0).getColumn()));
		//System.out.println(matrix3.toStringVector(matrix3.getRow(1).getColumn()));
		//System.out.println(matrix3.toStringVector(matrix3.getColumn(0).getColumn()));
		//System.out.println(matrix3.toStringVector(matrix3.getColumn(1).getColumn()));
		//System.out.println(matrix3.toString());
		
	}

}
