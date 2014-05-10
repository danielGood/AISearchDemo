package hPath;
import graph.CartesianPoint;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import tictactoe.Tile;
import ntile.OperatorSquare;
import ntile.Square;

public class VeTwo {
    
	
	
	
	private static HashMap	gValues = new HashMap();;
	
	
	public static <T, mySquareClass> void main(String[] args)  {

		//Daniel Good
		
		
		//g.toPrint();
		//Square mySquare = new Square(3);
		
	   
		
		//childRules cR = new OperatorSquare();
		Square<Tile> mySquare ;
		mySquare=solu();
	
		
		
		Square<Tile> mySquare2 ;
		mySquare2=assign();
		System.out.println(mySquare2.toString());
		childRules<Square<Tile>> cR = new OperatorSquare<Square<Tile>>();
		
		
		heuristicPathAlgorithm<Square<Tile>> hPA =new heuristicPathAlgorithm<Square<Tile>>(mySquare, mySquare2, (childRules<Square<Tile>>) cR);
		hPA.algo();
		//IDA<Square> myIDA= new IDA<Square>(mySquare2, mySquare, (childRules<Square>) cR);
		//myIDA.algo();
		
		
		
		//Square<Tile> mySquare3=(Square<Tile>) cR.clone((Square<Tile>) mySquare2);
		
		
		
		
		
		
	}// end of main

	
	
	
	
	
	
	
	
	static Square<Tile> assign(){
		CartesianPoint cp = new CartesianPoint(0, 1);
		Vector<Tile> tile=new Vector<Tile>(0);
		///  0   1   2
		///  3   4   5
		///  6   7   8
		
		
		Tile ta = new Tile(4);
		Tile tb = new Tile(1);
		Tile tc = new Tile(3);
		
		Tile td = new Tile(0);
		Tile te = new Tile(2);
		Tile tf = new Tile(6);
		
		Tile tg = new Tile(7);
		Tile th = new Tile(5);
		Tile ti = new Tile(8);
		
		tile.add(ta);
		tile.add(tb);
		tile.add(tc);
		tile.add(td);
		tile.add(te);
		tile.add(tf);
		tile.add(tg);
		tile.add(th);
		tile.add(ti);
		
		Square<Tile> mySquare = new Square<>(3, tile);

		
		
		return mySquare;
	}
	
	static Square<Tile> solu(){
		CartesianPoint cp = new CartesianPoint(2, 2);
		Vector<Tile> tile=new Vector<Tile>(0);
		///  0   1   2
		///  3   4   5
		///  6   7   8
		
		
		Tile ta = new Tile(1);
		Tile tb = new Tile(2);
		Tile tc = new Tile(3);
		
		Tile td = new Tile(4);
		Tile te = new Tile(5);
		Tile tf = new Tile(6);
		
		Tile tg = new Tile(7);
		Tile th = new Tile(8);
		Tile ti = new Tile(0);
		
		tile.add(ta);
		tile.add(tb);
		tile.add(tc);
		tile.add(td);
		tile.add(te);
		tile.add(tf);
		tile.add(tg);
		tile.add(th);
		tile.add(ti);
		
		Square<Tile> mySquare = new Square<>(3, tile);

		
		
		return mySquare;
	}
	
	
	
  
   
   
 
   
}// end of class




/*
3/20 current bug path finding, tends to skip over some steps, however all steps are accurate - not yet fixed
  3/21 fixed was a copy bug, copy gave it same parents, - so there are two general types of copies those with parents and those without (ironicly children)
anyways this is easily fixed in generateChildren with setParents(null)
*/