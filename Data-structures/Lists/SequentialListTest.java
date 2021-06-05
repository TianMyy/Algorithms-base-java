package list;

public class SequentialListTest {
	public static void main(String[] args) {
		//create sequence list
		SequentialList<String> sl = new SequentialList<>(5);
		//insert
		sl.insert("Jennie");
		sl.insert("Lisa");
		sl.insert("Rose");
		sl.insert("Jisoo");
		sl.insert("Alizabeth");
		//foreach
		for(String s : sl) {
			System.out.println(s);
		}
		//capacity
		System.out.println(sl.capacity());
		//insert
		sl.insert(3, "Bobbi");
		System.out.println(sl.capacity());
		//get
		String getres = sl.get(2);
		System.out.println("value of index 2: " + getres);
		//delete
		String removeres = sl.remove(1);
		System.out.println("Deleting value: " + removeres);
		//clear
		sl.clear();
		System.out.println("After clear, length is: " + sl.length());
	}
}
