package linear;

import java.util.Iterator;

public class DoubleLinkList<T> implements Iterable<T>{
	//head node;
	private Node head;
	//last node;
	private Node last;
	//length
	private int N;
	
	private class Node{
		Node pre;
		T item;
		Node next;
		public Node(T item, Node pre, Node next) {
			this.item = item;
			this.pre = pre;
			this.next = next;
		}
		
	}
	public DoubleLinkList() {
		last = null;
		head = new Node(null,null,null);
		N = 0;
	}
	
	//clear list
	public void clear() {
		last = null;
		head.next = null;
		head.pre = null;
		head.item = null;
		N = 0;
	}
	//is empty?
	public boolean isEmpty() {
		return N == 0;
	}
	//get the number of elements
	public int length() {
		return N;
	}
	
	//read and return the value of element which index is i
	public T get(int i) {
		if(i < 0 || i >= N) {
			throw new RuntimeException("Your position is incorrect!");
		}
		Node curr = head.next;
		for(int index = 0; index < i; index++) {
			curr = curr.next;
		}
		return curr.item;
	}
	
	//add an element
	public void inset(T t) {
		if (last == null){
			last = new Node(t,head,null);
			head.next = last;
		}else {
			Node oldLast = last;
			Node newNode = new Node(t,oldLast,null);
			oldLast.next = newNode;
			last = newNode;
		}
		N++; 
	}
	
	//insert an element which value is t before element which index is i
	public void insert(int i, T t) {
		if(i < 0 || i >= N) {
			throw new RuntimeException("Your position is incorrect!");
		}
		Node pre = head;
		for(int index = 0; index < i; index++) {
			pre = pre.next;
		}
		Node curr = pre.next;
		Node newNode = new Node(t,pre,curr);
		pre.next = newNode;
		newNode.next = curr;
		N++;
	}
	
	//delete and return the value of element which index is i
	public T remove(int i) {
		if(i < 0 || i >= N) {
			throw new RuntimeException("Your position is incorrect!");
		}
		Node pre = head;
		for(int index = 0; index < i-1; index++) {
			pre = pre.next;
		}
		Node del = pre.next;
		pre.next = del.next;
		del.next.pre = pre;
		N--;
		return del.item;
	}
	
	//return the index of searching element, if no return -1
	public int indexOf(T t) {
		Node temp = head;
		for(int index = 0; temp.next != null; index++) {
			temp = temp.next.next;
			if(temp.item.equals(t)) {
				return index;
			}
		}
		return -1;
	}
	
	//get the first element
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return head.next.item;
	}
	//get the last element
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return last.item;
	}
	
	@Override
	public Iterator iterator() {
		return new LIterator();
	}
	private class LIterator implements Iterator{
		private Node temp = head;
		
		@Override
		public boolean hasNext() {
			return temp.next != null;
		}
		
		@Override
		public Object next() {
			temp = temp.next;
			return temp.item;
		}
	}
}
