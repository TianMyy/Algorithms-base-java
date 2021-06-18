package tree_advanced;

public class RedBlackTreeTest {
	public static void main(String[] args) {
		RedBlackTree<Integer, String> rbt = new RedBlackTree<>();
		rbt.put(4, "Jisoo");
		rbt.put(1, "Rose");
		rbt.put(3, "Lisa");
		rbt.put(5, "Jennie");
		rbt.put(2, "Bobbi");
		
		System.out.println("test size(): " + rbt.size());
		System.out.println("test get(1): " + rbt.get(1));
		System.out.println("test get(3): " + rbt.get(3));
	}
}
