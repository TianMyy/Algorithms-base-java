package stack;

public class BracketsMatch {
	public static void main(String[] args) {
		String str = "(SH(CA)())";
		String str1 =  "((SH)CA))";
		System.out.println("Are the brackets matched? ");
		System.out.println(str + ": " + isMatch(str));
		System.out.println(str1 + ": " + isMatch(str1));
	}
	
	public static boolean isMatch(String str){
		Stack<String> sc = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				sc.push("(");
			}
			if(str.charAt(i) == ')') {
				String del = sc.pop();
				if(del == null) {
					return false;
				}
			}
		}
		if(sc.isEmpty()) {
			return true;
		}
		return false;
	}

}
