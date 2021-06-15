package tree;

public class BinaryTree<Key extends Comparable<Key>, Value> {
	private Node root;
	private int num;
	
	private class Node{
		public Key key;
		private Value value;
		public Node left;
		public Node right;
		public Node(Key key, Value value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	// get number of elements in tree
	public int size() {
		return num;
	}
	
	// Insert a pair into tree
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	// insert a pair to given tree and return new tree
	private Node put(Node x, Key key, Value value) {
		if(x == null) {
			num++;
			return new Node(key, value, null, null);
		}
		
		int compare = key.compareTo(x.key);
		if(compare > 0) {
			x.right = put(x.right, key, value);
		}else if(compare < 0) {
			x.left = put(x.left, key, value);
		}else {
			x.value = value;
		}
		return x;
	}
	
	// get paired value with given key
	public Value get(Key key) {
		return get(root, key);
	}
	
	// find value of key in given tree
	private Value get(Node x, Key key) {
		if(x == null) {
			return null;
		}
		int compare = key.compareTo(x.key);
		if(compare > 0) {
			return get(x.right, key);
		}else if(compare < 0) {
			return get(x.left, key);
		}else {
			return x.value;
		}
	}
	
	// delete pair in tree with given key
	public void delete(Key key) {
		delete(root, key);
	}

	// delete pair with key in given tree and return new tree
	private Node delete(Node x, Key key) {
		if(x == null) {
			return null;
		}
		int compare = key.compareTo(x.key);
		if(compare > 0) {
			x.right = delete(x.right, key);
		}else if(compare < 0) {
			x.left = delete(x.left, key);
		}else {
			// find the minimum node of given node's right
			// delete minimum node
			// let minimum's left and right == deleting node's left and right
			num--;
			if(x.right == null) {
				return x.left;
			}
			if(x.left == null) {
				return x.right;
			}
			// find minimum node
			Node minNode = x.right;
			while(minNode.left != null) {
				minNode = minNode.left;
			}
			// delete minimum node
			Node curr = x;
			while(curr.left != null) {
				if(curr.left.left == null) {
					curr.left = null;
				}else {
					curr = curr.left;
				}
			}
			// let minimum node's left and right == deleting node's left and right;
			minNode.left = x.left;
			minNode.right = x.right;
			// let root point to minimum node
			x = minNode;
		}
		return x;
	}
	
	// find key minimum node in tree
	public Key min() {
		return min(root).key;
	}
	
	// return the Node of minimum key in given tree
	private Node min(Node x) {
		while(x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	// find key maximum node in tree
	public Key max() {
		return max(root).key;
	}
	
	// return the Node of maximum key in given tree
	private Node max(Node x) {
		while(x.right != null) {
			x = x.right;
		}
		return x;
	} 
}
