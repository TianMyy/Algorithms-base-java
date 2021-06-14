package stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	// record head node
	private Node head;
	// record number of elements
	private int num;
	
	public class Node{
		T value;
		Node next;
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public Stack() {
		this.head = new Node(null, null);
		this.num = 0;
	}
	
	// determine if the stack is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// get number of element in stack
	public int size() {
		return num;
	}
	
	// push the element t into stack
	public void push(T t) {
		Node newNode = new Node(t, null);
		Node oldFirst = head.next;
		head.next = newNode;
		newNode.next = oldFirst;
		num++;
	}
	
	// pop the element at the top of stack
	public T pop() {
		Node oldFirst = head.next;
		if(oldFirst == null) {
			return null;
		}
		Node next = oldFirst.next;
		head.next = next;
		num--;
		return oldFirst.value;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new SIterator();
	}
	
	public class SIterator implements Iterator{
		private Node node;
		public SIterator() {
			this.node = head;
		}

		@Override
		public boolean hasNext(){
			return node.next != null;
		}
		
		@Override
		public Object next() {
			return node.next.value;
		}
	}
}
