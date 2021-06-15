package symbol;

public class SymbolTable<Key, Value> {
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
	
	public SymbolTable() {
		this.head = new Node(null, null, null);
		this.num = 0;
	}
	
	// get number of <key, value> paired
	public int size() {
		return num;
	}
	
	// insert a <key, value> paired to symbol table
	public void put(Key key, Value value) {
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
			// find if table has this key, just update value
			if(curr.key.equals(key)) {
				curr.value = value;
				return;
			}
		}
		
		// no such key, add new pair
		Node oldFirst = head.next;
		Node newFirst = new Node(key, value, oldFirst);
		head.next = newFirst;
		num++;		
	}
	
	// delete the pair in table that the key is given
	public void delete(Key key) {
		Node curr = head;
		while(curr.next != null) {
			if(curr.next.key.equals(key)) {
				curr.next = curr.next.next;
				num--;
				return;
			}
			curr = curr.next;
		}
	}
	
	// get value from table with given key
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
