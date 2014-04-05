package hPath;

import java.util.Vector;

public interface childRules<T> {
	Vector<T> getChildren(T myNode);
	int h(T myNode);
	T clone(T myNode);
	String toString(T myNode);
	int g(T parent, T child);
}
