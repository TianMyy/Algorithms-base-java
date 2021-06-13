package list;

public class JosephusInstance {
	public static void main(String[] args) {
		// 1.create circle linked list
		Node<Integer> first = null;
		// record previous node
		Node<Integer> pre = null;
		for (int i = 1; i <= 41; i++) {
			// first element
			if (i == 1){
				first = new Node(i, null);
				pre = first;
				continue;
			}
			Node<Integer> node = new Node<>(i, null);
			pre.next = node;
			pre = node;
			if (i == 41){
				// let last node point to first node
				pre.next = first;
			}
		}
		
		// 2.use count to record 
		int count = 0;
		Node<Integer> curr = first;
		Node<Integer> before = null;
		while(curr != curr.next) {
			count++;
			if(count == 3) {
				before.next = curr.next;
				System.out.print(curr.value + ", ");
				count = 0;
				curr = curr.next;
			}else {
				before = curr;
				curr = curr.next;
			}
		}
		System.out.println();
		System.out.println("last person: " + curr.value);
	}
}
