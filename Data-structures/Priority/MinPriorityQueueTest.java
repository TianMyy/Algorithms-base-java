package priority;

public class MinPriorityQueueTest {
	public static void main(String[] args) {
		MinPriorityQueue<String> minpq = new MinPriorityQueue<String>(10);
		minpq.insert("G");
		minpq.insert("F");
		minpq.insert("E");
		minpq.insert("D");
		minpq.insert("C");
		minpq.insert("B");
		minpq.insert("A");

		System.out.println("test size(): " + minpq.size());
        while(!minpq.isEmpty()){
            String min = minpq.delMin();
            System.out.print(min + " ");
        }
        System.out.println();
        System.out.println("test size() after deleting: " + minpq.size());
	}
}
