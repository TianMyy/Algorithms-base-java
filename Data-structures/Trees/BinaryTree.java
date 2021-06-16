package tree;

import queue.Queue;

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
	
	
	// TRAVERSALS
	// use pre-order traversal to get all keys in the tree
	public Queue<Key> preOrder(){
		Queue<Key> keys = new Queue<>();
		preOrder(root, keys);
		return keys;
	}
	
	// get all keys from given node and put in Queue keys
	private void preOrder(Node x, Queue<Key> keys) {
		if(x != null) {
			// put key of x into keys
			keys.enqueue(x.key);
			// recursion left child tree of node x
			preOrder(x.left, keys);
			// recursion right child tree of node x
			preOrder(x.right, keys);
		}
	}
	
	//use mid-order traversal to get all keys in the tree
	public Queue<Key> inOrder(){
		Queue<Key> keys = new Queue<>();
		inOrder(root, keys);
		return keys;
	}
	private void inOrder(Node x, Queue<Key> keys) {
		if(x != null) {
			inOrder(x.left, keys);
			keys.enqueue(x.key);
			inOrder(x.right, keys);
		}
	}
	
	// use after-order traversal to get all keys in the tree
	public Queue<Key> postOrder(){
		Queue<Key> keys = new Queue<>();
		postOrder(root, keys);
		return keys;
	}
	private void postOrder(Node x, Queue<Key> keys) {
		if(x != null) {
			postOrder(x.left, keys);
			postOrder(x.right, keys);
			keys.enqueue(x.key);
		}
	}
	
	// use sequence traversal get all keys in the tree
	public Queue<Key> sequence(){
		// define two queue to store keys and nodes in tree
		Queue<Key> keys = new Queue<>();
		Queue<Node> nodes = new Queue<>();
		// put root node to queue
		nodes.enqueue(root);
		
		while(!nodes.isEmpty()) {
			//dequeue a node in the queue, put the key into keys
			Node curr = nodes.dequeue();
			keys.enqueue(curr.key);
			// determine does node have left child node. if true, put into nodes
			if(curr.left != null) {
				nodes.enqueue(curr.left);
			}
			if(curr.right != null) {
				nodes.enqueue(curr.right);
			}
		}
		return keys;
	}
	
	
	//[MAX DEPTH]
	// get max depth of the entire tree
	public int maxDepth() {
		return maxDepth(root);
	}
	private int maxDepth(Node x) {
		if(x == null) {
			return 0;
		}
		// max depth of x
		int max = 0;
		// max depth of left child node
		int maxL = 0;
		// max depth of right child node
		int maxR = 0;
		// get the max depth of left child tree of node x
		if(x.left != null) {
			maxL = maxDepth(x.left);
		}
		// get the max depth of right child tree of node x
		if(x.right != null) {
			maxR = maxDepth(x.right);
		}
		max = maxL > maxR ? maxL+1 : maxR+1;
		return max;
	}
}
