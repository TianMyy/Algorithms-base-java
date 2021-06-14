package stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		st.push("Jisoo");
		st.push("Jennie");
		st.push("Lisa");
		st.push("Rose");
		st.push("Bobbi");
		st.push("Alizabeth");
		for(String s : st) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("test pop(): " + st.pop());
		System.out.println("test pop(): " + st.pop());
		System.out.println("test size(): " + st.size());
		System.out.println("---------------------------------------");
		
		Stack<Integer> si = new Stack<>();
		si.push(2);
		si.push(58);
		si.push(17);
		si.push(230);
		si.push(89);
		si.push(103);
		si.push(47);
		for(int i : si) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("test pop(): " + si.pop());
		System.out.println("test pop(): " + si.pop());
		System.out.println("test size(): " + si.size());
	}
}
