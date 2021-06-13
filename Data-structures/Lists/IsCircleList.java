package list;

public class IsCircleList {
	public static void main(String[] args) {
		Node<String> first = new Node<String>("aa", null);
		Node<String> second = new Node<String>("bb", null);
		Node<String> third = new Node<String>("cc", null);
		Node<String> fourth = new Node<String>("dd", null);
		Node<String> fifth = new Node<String>("ee", null);
		Node<String> six = new Node<String>("ff", null);
		Node<String> seven = new Node<String>("gg", null);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = six;
		six.next = seven;
		// make circle
		seven.next = third;
		
		// determine is the linked list have circle
		boolean circle = isCircle(first);
		System.out.println("is the linked list have circle：" + circle);
	}
	
	public static boolean isCircle(Node<String> first) {
		Node<String> slow = first;
		Node<String> fast = first;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	private static class Node<T> {
		T item;
		Node next;
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
}
