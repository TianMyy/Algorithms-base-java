package tree_advanced;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private Node root;
	private int num;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{
		public Key key;
		public Value value;
		public Node left;
		public Node right;
		public boolean color;
		public Node(Key key, Value value, Node left, Node right, boolean color) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.color = color;
		}
	}
	
	// get number of elments in tree
	public int size() {
		return num;
	}
	
	// determine whether the link its father node point to is is red
	private boolean isRed(Node x) {
		if(x == null) {
			return false;
		}
		return x.color == RED;
	}
	
	// turn left
	private Node rotateLeft(Node h) {
		// find right node of h
		Node x = h.right;
		// find left node of x, let x.left=h.right
		h.right = x.left;
		// let h=x.left
		x.left = h;
		// set x.color=h.color
		x.color = h.color;
		// set h.color=red
		h.color = RED;
		return x;
	}
	
	// turn right
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;		
	}
	
	// correct color
	private void flipColors(Node h) {
		// current node change to red
		h.color = RED;
		// left node and right node change to black
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	// complete insertion for entire tree
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}
	
	// complete insertion for given tree
	public Node put(Node h, Key key, Value value) {
		if(h == null) {
			num++;
			return new Node(key, value, null, null, RED);
		}
		// compare h and key
		int comp = key.compareTo(h.key);
		if(comp < 0) {
			h.left = put(h.left, key, value);
		}else if(comp > 0) {
			h.right = put(h.right, key, value);
		}else {
			h.value = value;
		}
		
		// turn left
		if(isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		if(isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		if(isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		return h;
	}
	
	// according to given key, find out paired value
	public Value get(Key key) {
		return get(root, key);
	}
	private Value get(Node h, Key key) {
		if(h == null) {
			return null;
		}
		// compare x.key and key
		int comp = key.compareTo(h.key);
		if(comp < 0) {
			return get(h.left, key);
		}else if(comp > 0) {
			return get(h.right, key);
		}else {
			return h.value;
		}
	}
}
