package priority;

public class MaxPriorityQueueTest {
	public static void main(String[] args) {
		MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(10);
		maxpq.insert("A");
		maxpq.insert("B");
		maxpq.insert("C");
		maxpq.insert("D");
		maxpq.insert("E");
		maxpq.insert("F");
		maxpq.insert("G");
		
		System.out.println("test size(): " + maxpq.size());
		while(!maxpq.isEmpty()) {
			String temp = maxpq.delMax();
			System.out.print(temp + " ");
		}
		System.out.println();
		System.out.println("test size() after deleting: " + maxpq.size());
	}
}
