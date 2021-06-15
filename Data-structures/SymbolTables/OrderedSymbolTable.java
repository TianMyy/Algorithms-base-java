package symbol;

public class OrderedSymbolTable<Key extends Comparable<Key>, Value> {
	private Node head;
	private int num;
	
	public class Node{
		Key key;
		Value value;
		Node next;
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public OrderedSymbolTable() {
		this.head = new Node(null, null, null);
		this.num = 0;
	}
	
	// get number of pairs in table
	public int size() {
		return num;
	}
	
	// insert pair into table
	public void put(Key key, Value value) {
		// initiate two node to record current and previous node
		Node curr = head.next;
		Node pre = head;
		while(curr != null && key.compareTo(curr.key) > 0) {
			pre = curr;
			curr = curr.next;
		}
		// if curr.key == given key, just update value
		if(curr != null && key.compareTo(key) == 0) {
			curr.value = value;
			return;
		}
		Node newNode = new Node(key, value, curr);
		pre.next = newNode;
		num++;
	}
	
	// delete pair that key is given key in table
	public void delete(Key key) {
		Node curr = head;
		while(curr.next != null) {
			if(curr.next.key.equals(key)) {
				curr.next = curr.next.next;
				num--;
				return;
			}
			curr= curr.next;
		}
	}
	
	// get value with given key in table
	public Value get(Key key) {
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
			if(curr.key.equals(key)) {
				return curr.value;
			}
		}
		return null;
	}
}
