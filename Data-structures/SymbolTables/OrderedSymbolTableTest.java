package symbol;

public class OrderedSymbolTableTest {
	public static void main(String[] args) {
		OrderedSymbolTable<Integer, String> ost = new OrderedSymbolTable<>();
		ost.put(1, "Bobbi");
		ost.put(2, "David");
		ost.put(3, "Rose");
		ost.put(2, "Jinnie");
		ost.put(4, "Lisa");
		ost.put(5, "Jisoo");
		ost.put(3, "Alizabeth");
		System.out.println(ost.get(1) +" "+ ost.get(2) +" "+ ost.get(3) +" "+ 
							ost.get(4) +" "+ ost.get(5));
		System.out.println("test size(): " + ost.size());
		ost.put(4, "Alizabeth");
		System.out.println("test get(5): " + ost.get(6));
		ost.put(5, "Judie");
		System.out.println("test put(5, 'Judie'): " + ost.get(6));
		ost.delete(2);
		System.out.println("test after delete(2) size(): " + ost.size());
	}
}
