package graph;

public class Link {
	private Node n;
	private Node m;
	private int length;

	Link(Node i, Node j, int length) {
		n = i;
		m = j;
		this.length = length;
	}

	boolean equals(Link l) {
		boolean de = false;

		Node i = l.getN();
		Node j = l.getM();
		// n--m
		// i--j
		if (i.equals(n) && j.equals(m) && length == l.getLength())
			de = true;
		if (i.equals(m) && j.equals(n) && length == l.getLength())
			de = true;
		return de;

	}

	int getLength() {
		return length;
	}

	Node getN() {
		return n;
	}

	Node getM() {
		return m;
	}

	void toPrint() {
		System.out.println(n.getLabel() + " " + m.getLabel());
	}
	
	public Link clone(){
		Link l = new Link(n.clone(), m.clone(), length);
		return l;
	}
 
}
