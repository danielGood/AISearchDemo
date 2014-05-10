package matrix;

import static org.junit.Assert.*;
import graph.CartesianPoint;
import hPath.childRules;

import java.util.Iterator;
import java.util.Vector;

import ntile.OperatorSquare;
import ntile.Square;

import org.junit.Test;

import tictactoe.Tile;

public class ListToMatrixTest {

	
	
	
	@Test
	public void testCons() {
		Square<Tile> mySquare=assign();
		ListToMatrix<Tile> matrix =mySquare.getFlux();
		//System.out.println(mySquare.toString());
		assertEquals(4, matrix.get(0, 0).getValue());
		assertEquals(0, matrix.get(0, 1).getValue());
		assertEquals(7, matrix.get(0, 2).getValue());
		assertEquals(0, mySquare.getBlankIndex().getX());
		assertEquals(1, mySquare.getBlankIndex().getY());
		
	}
	
	@Test
	public void testClone() {
		Square<Tile> mySquare=assign();
		ListToMatrix<Tile> matrix =mySquare.getFlux();
		childRules<Square<Tile>> cR = new OperatorSquare<Square<Tile>>();
		Square<Tile> mySquare2=cR.clone(mySquare);
		System.out.println(mySquare2.toString());
		System.out.println(mySquare.toString());
		assertEquals(4, matrix.get(0, 0).getValue());
		System.out.println(mySquare2.hashCode());
		
	}
	
	@Test
	public void testEquals() {
		System.out.println("square1");
		Square<Tile> mySquare=assign();
		ListToMatrix<Tile> matrix =mySquare.getFlux();
		childRules<Square<Tile>> cR = new OperatorSquare<Square<Tile>>();
		System.out.println("square2");
		Square<Tile> mySquare2=cR.clone(mySquare);
		System.out.println("square3");
		Square<Tile> mySquare3=cR.clone(mySquare);
		mySquare3.switchTile(0, 0);
		//System.out.println(mySquare);
		//System.out.println(mySquare2);
		//System.out.println(mySquare3);
		assertTrue(mySquare.equals(mySquare2));
		assertTrue(!(mySquare.equals(mySquare3)));
		
	}
	
	@Test
	public void testHash() {
		Square<Tile> mySquare=assign();
		ListToMatrix<Tile> matrix =mySquare.getFlux();
		childRules<Square<Tile>> cR = new OperatorSquare<Square<Tile>>();
		Square<Tile> mySquare2=cR.clone(mySquare);
		Square<Tile> mySquare3=cR.clone(mySquare);
		//System.out.println(mySquare2);
		mySquare3.switchTile(0, 0);
		//System.out.println(mySquare3);
		assertEquals(mySquare.hashCode(), mySquare2.hashCode());
		assertTrue(!(mySquare.hashCode()==mySquare3.hashCode()));
		
	}
	@Test
	public void testChildren(){
		Square<Tile> mySquare=assign();
		childRules<Square<Tile>> cR = new OperatorSquare<Square<Tile>>();
		Vector<Square<Tile>> children= cR.getChildren(mySquare);
		Iterator<Square<Tile>> id =children.iterator();
		//System.out.println(mySquare.toString());
		//System.out.println("children");
		while(id.hasNext()){
			Square<Tile> s=id.next();
			//System.out.println(s.toString());
		}
	}
	@Test
	public void testSimple(){
		Square<Tile> mySquare=assign();
		childRules<Square<Tile>> cR = new OperatorSquare<Square<Tile>>();
		Square<Tile> mySquare2=cR.clone(mySquare);
		Iterator<Integer> id =mySquare2.getSimpleForm().iterator();
		
		while(id.hasNext()){
			//System.out.println(id.next());
		}
	}
	
	
	Square<Tile> assign(){
		
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

}
