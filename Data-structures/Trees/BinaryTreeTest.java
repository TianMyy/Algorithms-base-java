package tree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree<Integer, String> bt = new BinaryTree<>();
		bt.put(1, "Bobbi");
		bt.put(4, "David");
		bt.put(9, "Rose");
		bt.put(12, "Jinnie");
		System.out.println("test size(): " + bt.size());
		bt.put(3, "Lisa");
		bt.put(10, "Jisoo");
		bt.put(7, "Alizabeth");
		System.out.println("test get(3): " + bt.get(3));
		bt.delete(7);
		System.out.println("test size after delete(7): " + bt.size());
		System.out.println("test min(): " + bt.min());
		System.out.println("test max(): " + bt.max());
	}
}
