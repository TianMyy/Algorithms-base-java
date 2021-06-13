package list;

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		SinglyLinkedList<String> sll= new SinglyLinkedList<>(); 
		sll.insert("Jennie");
		sll.insert("Lisa");
		sll.insert("Rose");
		sll.insert("Jisoo");
		sll.insert("Alizabeth", 3);
		sll.insert("Bobbi");
		sll.insert("Nancy", 6);
		for(String s : sll) {
			System.out.print(s + " ");
		}
		System.out.println();
		// test length()
		System.out.println("test length(): " + sll.length());
		// test get()
		System.out.println("test get(): " + sll.get(3));
		// test remove
		System.out.println("test remove(5): " + sll.remove(5) + " length: " + sll.length());
		for(String s : sll) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		SinglyLinkedList<Integer> sll2= new SinglyLinkedList<>(); 
		sll2.insert(2);
		sll2.insert(58);
		sll2.insert(17);
		sll2.insert(230);
		sll2.insert(6, 1);
		sll2.insert(89);
		sll2.insert(103);
		sll2.insert(47, 5);
		for(Integer i : sll2) {
			System.out.print(i + " ");
		}
		System.out.println();
		// test length()
		System.out.println("test length(): " + sll2.length());
		// test get()
		System.out.println("test get(): " + sll2.get(3));
		// test remove
		System.out.println("test remove(5): " + sll2.remove(5) + " length: " + sll2.length());
		for(Integer i : sll2) {
			System.out.print(i + " ");
		}
	}
}
