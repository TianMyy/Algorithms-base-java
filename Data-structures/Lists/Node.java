package list;

public class Node<T> {
	//stored element
	public T value;
	//point to next node;
	public Node next;

	public Node(T value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	
	public static void main(String[] args) {
		//create nodes
		Node<Integer> first = new Node<Integer>(11, null);
		Node<Integer> second = new Node<Integer>(13, null);
		Node<Integer> third = new Node<Integer>(12, null);
		Node<Integer> fourth = new Node<Integer>(8, null);
		Node<Integer> fifth = new Node<Integer>(9, null);
		//generate linked list
		first.next = second;
		second.next = third;
		third.next = fourth; 
		fourth.next = fifth;
	}
}


