package tree;

import queue.Queue;

public class OrderTraversalTest {
	public static void main(String[] args) {
		BinaryTree<String, String> btt = new BinaryTree<>();
		btt.put("E", "5");
		btt.put("B", "2");
		btt.put("G", "7");
		btt.put("A", "1");
		btt.put("D", "4");
		btt.put("F", "6");
		btt.put("H", "8");
		btt.put("C", "3");
		
		System.out.println("[test pre-order traversal]");
		Queue<String> pre = btt.preOrder();
		for(String key : pre) {
			System.out.println(key + ": " + btt.get(key));
		}
		System.out.println("-----------------------------------------------------");
		
		System.out.println("[test in-order traversal]");
		Queue<String> in = btt.inOrder();
		for(String key : in) {
			System.out.println(key + ": " + btt.get(key));
		}
		System.out.println("-----------------------------------------------------");
		
		System.out.println("[test post-order traversal]");
		Queue<String> post = btt.postOrder();
		for(String key : post) {
			System.out.println(key + ": " + btt.get(key));
		}
		System.out.println("-----------------------------------------------------");
	}
}
