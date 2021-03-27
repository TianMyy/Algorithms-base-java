package linear;

public class LinkList {
	public static void main(String[] args) {
		//define node
		Node<Integer> first = new Node<Integer>(11,null);
		Node<Integer> second = new Node<Integer>(13,null);
		Node<Integer> third = new Node<Integer>(12,null);
		Node<Integer> fourth = new Node<Integer>(8,null);
		Node<Integer> fifth = new Node<Integer>(9,null);
		
		//create link list
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
	}
}

class Node<T>{
	//store elements
	public T item;
	//point to the next node
	public Node next;
	
	public Node(T item, Node next) {
		this.item = item;
		this.next = next;
	}
}
