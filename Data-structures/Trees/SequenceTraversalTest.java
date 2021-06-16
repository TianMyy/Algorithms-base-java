package tree;

import queue.Queue;

public class SequenceTraversalTest {
	public static void main(String[] args) {
		BinaryTree<String, String> bt = new BinaryTree<>();
		bt.put("E", "5");
		bt.put("B", "2");
		bt.put("G", "7");
		bt.put("A", "1");
		bt.put("D", "4");
		bt.put("F", "6");
		bt.put("H", "8");
		bt.put("C", "3");
		Queue<String> queue = bt.sequence();
		for (String key : queue) {
			System.out.println(key + ": " + bt.get(key));
		}
	}
}
