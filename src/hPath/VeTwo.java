package hPath;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class VeTwo {
    
	
	
	
	private static HashMap	gValues = new HashMap();;
	
	
	public static <T, mySquareClass> void main(String[] args)  {

		//Daniel Good
		
		
		//g.toPrint();
		Square mySquare = new Square(3);
		Class aClass = Square.class;
		String className= aClass.getName();
		//heuristicPathAlgorithm<Square> myPath = new heuristicPathAlgorithm<Square>(mySquare, className);
	   
		
		childRules cR = new OperatorSquare();
		
	
		
		
		Square mySquare2 = new Square(3);
		mySquare2=assign();
		//mySquare2.toPrint();
		heuristicPathAlgorithm<Square> myPath = new heuristicPathAlgorithm<Square>(mySquare2, mySquare, className, cR);
	    myPath.algo();
		System.out.println();
		System.out.println();
		System.out.println();
		
	
		
		
		
		
		
		
		
	}// end of main

	
	
	
	
	
	
	
	
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
	
	
	
	
	
  
   
   
 
   
}// end of class




/*
3/20 current bug path finding, tends to skip over some steps, however all steps are accurate - not yet fixed
  3/21 fixed was a copy bug, copy gave it same parents, - so there are two general types of copies those with parents and those without (ironicly children)
anyways this is easily fixed in generateChildren with setParents(null)
*/