package list;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T>{
	// record head node
	private Node head;
	// record size of linked list
	private int num;
	
	public SinglyLinkedList() {
		this.head = new Node(null, null);
		this.num = 0;
	}
	
	// clear linked list
	public void clear() {
		head.next = null;
		num = 0;
	}
	
	// get the size of linked list
	public int length() {
		return num;
	}
	
	// determine if the list is empty
	public boolean isEmpty() {
		return num == 0;
	}
	
	// get the element of index i
	public T get(int i) {
		Node curr = head.next;
		int count = 1;
		while(count < i) {
			curr = curr.next;
			count++;
		}
		return (T) curr.value;
	}
	
	// add element to list
	public void insert(T t) {
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(t, null);
		num++;
	}
	
	// add element t to index i
	public void insert(T t, int i) {
		Node pre = head;
		for(int index = 0; index < i-1; index++) {
			pre = pre.next;
		}
		Node next = pre.next;
		pre.next = new Node(t, next);
		num++;
	}
	
	//delete element at index i and return the deleted element
	public T remove(int i) {
		// got node before index i
		Node pre = head;
		for(int index = 0; index < i-1; index++) {
			pre = pre.next;
		}
		Node del = pre.next;
		pre.next = del.next;
		num--;
		return (T) del.value;
	}
	
	// find the first appearance of t in list
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

	@Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
    	private Node node;
    	public LIterator() {
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

    // reverse the whole linked list
    public void reverse(){
    	// determine whether the linked list is empty, if is, return; if not, call overload reverse method
    	if(isEmpty()) {
    		return;
    	}
    	reverse(head.next);
    }

    // reverse and return
    public Node reverse(Node curr){
    	if(curr.next == null) {
    		head.next = curr;
    		return curr;
    	}
        // recursion to always return the previous node
        Node pre = reverse(curr.next);
        // make next of returned node as current node
        pre.next = curr;
        // make the next node of current node as null
        curr.next = null;
        return curr;
    }
	
	
}
