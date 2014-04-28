package simplesearch;

public class treetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		BTNode<Integer> t1= new BTNode<Integer>(5, null, null);
		
		//5
		BTNode<Integer> t2= new BTNode<Integer>(9, null, null);
		BTNode<Integer> t3= new BTNode<Integer>(2, null, null);
		
		t1.setLeft(t2);
		t1.setRight(t3);
		
		//5
		//9 2
		
		
		BTNode<Integer> t4= new BTNode<Integer>(7, null, null);
		BTNode<Integer> t5= new BTNode<Integer>(4, null, null);
		BTNode<Integer> t6= new BTNode<Integer>(14, null, null);
		BTNode<Integer> t7= new BTNode<Integer>(3, null, null);
		
		t2.setLeft(t4);
		t2.setRight(t5);
		t3.setLeft(t6);
		t3.setRight(t7);
		
		
		
		BTNode<Integer> t8= new BTNode<Integer>(8, null, null);
		BTNode<Integer> t9= new BTNode<Integer>(9, null, null);
		BTNode<Integer> t10= new BTNode<Integer>(7, null, null);
		BTNode<Integer> t11= new BTNode<Integer>(19, null, null);
		BTNode<Integer> t12= new BTNode<Integer>(8, null, null);
		BTNode<Integer> t13= new BTNode<Integer>(5, null, null);
		BTNode<Integer> t14= new BTNode<Integer>(4, null, null);
		BTNode<Integer> t15= new BTNode<Integer>(2, null, null);
		
		t4.setLeft(t8);
		t4.setRight(t9);
		t5.setLeft(t10);
		t5.setRight(t11);
		t6.setLeft(t12);
		t6.setRight(t13);
		t7.setLeft(t14);
		t7.setRight(t15);
		
		
		t1.print(0);
		
		
		
	}
	
	
	
	

}
