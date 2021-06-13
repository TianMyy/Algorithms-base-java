package list;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoublyLinkedList<String> dll = new DoublyLinkedList<>();
		dll.insert("Jennie");
		dll.insert("Lisa");
		dll.insert("Rose");
		dll.insert("Jisoo");
		dll.insert(1,"Alizabeth");
		dll.insert("Bobbi");
		dll.insert(3, "Nancy");
		for(String s : dll) {
			System.out.print(s + " ");
		}
		System.out.println();
		// test length()
		System.out.println("test length(): " + dll.length());
		// test get()
		System.out.println("test get(): " + dll.get(2));
		// test remove
		System.out.println("test remove(5): " + dll.remove(4) + " length: " + dll.length());
		// test getFirst() getLast()
		System.out.println("test getFirst(): " + dll.getFirst());
		System.out.println("test getLast(): " + dll.getLast());
		// test indexOf
		System.out.println("test indexOf('Bobbi'): " + dll.indexOf("Bobbi"));
		for(String s : dll) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		DoublyLinkedList<Integer> dll2 = new DoublyLinkedList<>();
		dll2.insert(2);
		dll2.insert(58);
		dll2.insert(17);
		dll2.insert(230);
		dll2.insert(1, 6);
		dll2.insert(89);
		dll2.insert(103);
		dll2.insert(5, 47);
		for(Integer i : dll2) {
			System.out.print(i + " ");
		}
		System.out.println();
		// test length()
		System.out.println("test length(): " + dll2.length());
		// test get()
		System.out.println("test get(): " + dll2.get(5));
		// test remove
		System.out.println("test remove(5): " + dll2.remove(6) + " length: " + dll2.length());
		// test getFirst() getLast()
		System.out.println("test getFirst(): " + dll2.getFirst());
		System.out.println("test getLast(): " + dll2.getLast());
		// test indexOf
		System.out.println("test indexOf(103): " + dll2.indexOf(103));
		for(Integer i : dll2) {
			System.out.print(i + " ");
		}
	}
}
