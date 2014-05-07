package simplesearch;

import java.util.Vector;

public interface TreeSearch<T, E> {
	Vector<T> getChildren(T myNode);
	
	
	
	int h(T myNode);
	int g(T parent, T child);
	
	T clone(T myNode);
	String toString(T myNode);
	
	boolean isLeaf(T myNode);
	boolean isRoot(T myNode);
	
	E NodeValue(T myNode);
	
	
	@Override
	public boolean equals(Object obj);
	
	
	public void setTurn(String s);//max or min for minimax
	
}
