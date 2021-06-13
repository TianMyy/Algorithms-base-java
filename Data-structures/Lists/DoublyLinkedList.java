package list;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
	// design node class for doubly linked list
	public class Node{
		T value;
		Node pre;
		Node next;
		public Node(T value, Node pre, Node next) {
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}
	
	// head of list
	private Node head;
	// last of list
	private Node last;
	// size of list
	private int num;
	public DoublyLinkedList() {
		head = new Node(null, null, null);
		last = null;
		num = 0;
	}
	
	// clear the list
	public void clear() {
		last = null;
		head.next = last;
		head.pre = null;
		head.value = null;
		num = 0;
	}
	
	// get size of list
	public int length() {
		return num;
	}
	
	// determine if the list is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// get the first element
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return head.next.value;
	}
	
	// get the last element
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return last.value;
	}
	
	//insert element t
	public void insert(T t) {
		if(isEmpty()) {
			Node newNode = new Node(t, head, null);
			last = newNode;
			head.next = last;
		}else {
			Node preLast = last;
			Node newLast = new Node(t, preLast, null);
			preLast.next = newLast;
			last = newLast;
		}
		num++;
	}
	
	// insert element t at index i
	public void insert(int i, T t) {
		Node pre = head;
		for(int index = 0; index < i; index++) {
			pre = pre.next;
		}
		Node curr = pre.next;
		Node newNode = new Node(t, pre, curr);
		pre.next = newNode;
		curr.pre = newNode;
		num++;
	}
	
	// get element at index i
	public T get(int i) {
		Node curr = head.next;
		for(int index = 0; index < i; index++) {
			curr = curr.next;
		}
		return curr.value;
	}
	
	// get the first appearance of elment t in list
	public int indexOf(T t) {
		Node curr = head;
		for(int i = 0; curr.next != null; i++) {
			curr = curr.next;
			if(curr.value.equals(t)) {
				return i;
			}
		}
		return -1;
	}
	
	// delete the element at index x and return 
	public T remove(int i) {
		Node curr = head;
		for(int index = 0; index < i; index++) {
			curr = curr.next;
		}
		Node del = curr.next;
		Node next = del.next;
		curr.next = next;
		next.pre = curr;
		num--;
		return del.value;
	}
	
	
	@Override
	public Iterator<T> iterator(){
		return new DIterator();
	}
	
	private class DIterator implements Iterator{
		private Node node;
		public DIterator() {
			this.node =head;
		}
		@Override
		public boolean hasNext() {
			return node.next != null;
		}
		@Override
		public T next() {
			node = node.next;
			return node.value;
		}
	}
	
}
