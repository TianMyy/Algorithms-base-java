package tree_advanced;

import java.util.Scanner;

public class UnionFindTreeTest {
	public static void main(String[] args) {
		UnionFindTree uft = new UnionFindTree(5);
		System.out.println("As default, there are " + uft.count() +" groups");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter first element: ");
			int p = sc.nextInt();
			System.out.println("Enter second element: ");
			int q = sc.nextInt();
			
			if(uft.connected(p, q)) {
				System.out.println(p +" and "+q +" already in the same group");
				continue;
			}
			uft.union(p, q);
			System.out.println("There are still "+ uft.count() +" groups");
		}
	}
}
