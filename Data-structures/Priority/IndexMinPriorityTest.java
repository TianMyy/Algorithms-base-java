package priority;

public class IndexMinPriorityTest {
	public static void main(String[] args) {
		IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        queue.insert(0, "A");
        queue.insert(1, "C");
        queue.insert(2, "F");
        queue.insert(3, "H");

        System.out.println("test changeItem(2, \"B\")");
        queue.changeItem(2, "B");

        System.out.println("test size(): " + queue.size());
        System.out.println("test delMin(): " + queue.delMin());
        while(!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index+" ");
        }
        System.out.println();
        System.out.println("test size() after deleting: " + queue.size());
	}
}
