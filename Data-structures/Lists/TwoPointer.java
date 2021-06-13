package list;

public class TwoPointer {
	public static void main(String[] args) throws Exception {
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
		
		//find the middle node
		String mid = getMid(first);
		System.out.println("middle value is：" + mid);
	}
		
	public static String getMid(Node<String> first) {
		Node<String> slow = first;
		Node<String> fast = first;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.value;
	}
	
	// Node class
	private static class Node<T> {
		T value;
		Node next;
		
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
