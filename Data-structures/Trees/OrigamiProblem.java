package tree;

import queue.Queue;

public class OrigamiProblem {
	public static void main(String[] args) {
		Node tree = createTree(4);
		printTree(tree);		
	}
	
	// create a origami tree with depth n
	public static Node createTree(int n) {
		Node root = null;
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				// the first time to fold the paper, create root node
				root = new Node("down", null, null);
			}else {
				// not the first time, use queue to store nodes
				Queue<Node> queue = new Queue<>();
				queue.enqueue(root);
				// recurse the queue
				while(!queue.isEmpty()) {
					// get a node from queue
					Node temp = queue.dequeue();
					if(temp.left != null) {
						queue.enqueue(temp.left);
					}
					if(temp.right != null) {
						queue.enqueue(temp.right);
					}
					// determine left and right all not empty, if empty, create nodes
					if(temp.left == null && temp.right == null) {
						temp.left = new Node("down", null, null);
						temp.right = new Node("up", null, null);
					}
				}
			}
		}
		return root;
	}
	
	// use in-order to print all the nodes in the tree
	public static void printTree(Node t) {
		if(t == null) {
			return;
		}
		printTree(t.left);
		System.out.print(t.value + ", ");
		printTree(t.right);
	}
	
	// design class Node
	public static class Node{
		String value;
		Node left;
		Node right;
		public Node(String value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
