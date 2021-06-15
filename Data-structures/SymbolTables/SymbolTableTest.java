package symbol;

public class SymbolTableTest {
	public static void main(String[] args) {
		SymbolTable<Integer, String> st = new SymbolTable<>();
		st.put(1, "Jisoo");
		st.put(2, "Rose");
		st.put(3, "Jinnie");
		st.put(4, "Lisa");
		st.put(5, "Bobbi");
		st.put(6, "David");
		System.out.println("test size(): " + st.size());
		st.put(4, "Alizabeth");
		System.out.println("test get(6): " + st.get(6));
		st.put(6, "Judie");
		System.out.println("test put(6, 'Judie'): " + st.get(6));
		st.delete(2);
		System.out.println("test after delete(2) size(): " + st.size());
	}
}
