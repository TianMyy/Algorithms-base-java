package linear;

public class DoubleLinkListTest {
	public static void main(String[] args) throws Exception {
		DoubleLinkList<String> list = new DoubleLinkList<>();
		list.inset("John");
		list.inset("Peter");
		list.inset("Tom");
		list.inset("Mary");
		list.inset("Alice");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("----------------------");
		String tow = list.get(2);
		System.out.println(tow);
		System.out.println("-------------------------");
		String remove = list.remove(3);
		System.out.println(remove);
		System.out.println(list.length());
		System.out.println("--------------------");
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
	}
}
