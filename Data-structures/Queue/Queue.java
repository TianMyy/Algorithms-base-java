package queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	private Node head;
	private Node last;
	private int num;
	
	public class Node{
		T value;
		Node next;
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public Queue() {
		this.head = new Node(null, null);
		this.last = null;
		this.num = 0;
	}
	
	// determine whether queue is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// get the number of elements in queue
	public int size() {
		return num;
	}
	
	// insert element t to queue
	public void enqueue(T t) {
		if(last == null) {
			last = new Node(t, null);
			head.next = last;
		}else {
			Node oldLast = last;
			last = new Node(t, null);
			oldLast.next = last;
		}
		num++;
	}
	
	// get one element from queue
	public T dequeue() {
		if(isEmpty()){
			return null;
		}
		Node first = head.next;
		Node next = first.next;
		head.next = next;
		num--;
		
		if(isEmpty()) {
			last = null;
		}
		return first.value;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new QIterator();
	}
	
	public class QIterator implements Iterator{
		private Node node;
		public QIterator() {
			this.node = head;
		}
		
		@Override
		public boolean hasNext() {
			return node.next != null;
		}
		
		@Override
		public Object next() {
			node = node.next;
			return node.value;
		}	
	}
}
