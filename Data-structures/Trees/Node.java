package tree;

public class Node<Key, Value> {
	// store key
	public Key key;
	// store value
	public Value value;
	// record left node
	public Node left;
	// record right node
	public Node right;
	
	public Node(Key key, Value value, Node left, Node right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}
