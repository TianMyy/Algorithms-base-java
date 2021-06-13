package list;

public class FindCircleListEntrance {
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
		Node<String> entrance = getEntrance(first);
		System.out.println("the entrance of circle list is：" + entrance.value);
	}
	
	public static Node getEntrance(Node<String> first) {
		Node<String> slow = first;
		Node<String> fast = first;
		Node<String> temp = null;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow.equals(fast)) {
				temp = first;
				continue;
			}
			if(temp != null) {
				temp = temp.next;
				if(temp.equals(slow)) {
					return temp;
				}
			}
		}
		return null;
	}
	
	public static class Node<T>{
		T value;
		Node next;
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
