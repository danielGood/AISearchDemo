package simplesearch;

public class SimpleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//2*n+1  and 2*n+2
		int tree[] ={
				
				          7,//0
				   9,                0,//(1, 2) 
				3,	    5,         11, 15, //(3 4) (5 6)
				5,	8, 6, 4,     2, 10, 12, 13  //(7 8)  (9 10)  (11 12) (13 14)
			};
		int solution = 5;
		
		//breadthFirst(tree, solution);
		//depthFirst(tree,solution, 0);
		
		iterativeDeepeningDepthFirst(tree,solution);
	}
	
	
	static boolean depthFirst(int tree[], int solution, int index){
		   System.out.println(tree[index]);
		   boolean notSolved=true;
		if (tree[index] == solution) {
			System.out.println("Found Solution " + solution + " at index "+index);
			notSolved=false;
		} else {
			int size = tree.length;
			if (2 * index + 1 < size && notSolved) {
				notSolved=depthFirst(tree, solution, 2 * index + 1);
			}
			if (2 * index + 2 < size&& notSolved) {
				notSolved=depthFirst(tree, solution, 2 * index + 2);
			}
		}
		return notSolved;
	}
	
	
	
	static void breadthFirst(int tree[], int solution){
		int index=0;
		int size = tree.length;
		boolean notfound =true;
		while(index<size && notfound){
			if(tree[index]==solution){
				notfound=false;
				System.out.println("Found Solution " + solution + " at index "+index);
			}
			
			
			index++;
		}
		
	}
	
	
	static void iterativeDeepeningDepthFirst(int tree[], int solution){
		
		int maxDepth=0;
		boolean notSolved =true;
		//assumes solution is in tree
		while(notSolved){
			notSolved=iter(tree,solution, 0, 0, maxDepth);
			maxDepth++;
		}
		
	}
	
	
	static boolean iter(int tree[], int solution, int index, int depth, int maxDepth){
		   
		   depth++;
		   
		   
		   System.out.println(tree[index]+ "   "+ depth);
		   boolean notSolved=true;
		if (tree[index] == solution) {
			System.out.println("Found Solution " + solution + " at index "+index);
			notSolved=false;
		} else if(depth<maxDepth) {
			int size = tree.length;
			if (2 * index + 1 < size && notSolved) {
				notSolved=iter(tree, solution, 2 * index + 1, depth, maxDepth);
			}
			if (2 * index + 2 < size&& notSolved) {
				notSolved=iter(tree, solution, 2 * index + 2, depth, maxDepth);
			}
		}
		return notSolved;
	}
	
	void uniformCost(int tree[], int solution){
		
	}
	
	
	void biDirectionalSearch(int tree[], int solution){
		
	}

}
