package heap;

public class HeapTest {
	public static void main(String[] args) {	
		Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

		System.out.println("test delMax(): ");
		String del = null;
		while((del = heap.delMax()) != null) {
			System.out.print(del + " ");
		}
	}
}
