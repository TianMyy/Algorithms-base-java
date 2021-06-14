package stack;

public class ReversePolishNotation {
	public static void main(String[] args) {
		// RPN of 3*（17-15）+ 18/6
		String[] notation = {"3", "17", "15", "-", "*","18", "6","/","+"};
		int result = caculate(notation);
		System.out.println("The result of RPN is：" + result);
	}
		
	public static int caculate(String[] notation){
		Stack<Integer> si = new Stack<>();
		for(int i = 0; i < notation.length; i++) {
			int one;
			int two;
			int res;
			if(notation[i] == "-") {
				one = si.pop();
				two = si.pop();
				res = two - one;
				si.push(res);
			}else if(notation[i] == "+") {
				one = si.pop();
				two = si.pop();
				res = two + one;
				si.push(res);
			}else if(notation[i] == "*") {
				one = si.pop();
				two = si.pop();
				res = two * one;
				si.push(res);
			}else if(notation[i] == "/") {
				one = si.pop();
				two = si.pop();
				res = two / one;
				si.push(res);
			}else {
				si.push(Integer.valueOf(notation[i]));
			}
		}
		return si.pop();
	}
}
