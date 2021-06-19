package tree_advanced;

import java.util.Scanner;

public class UnionFindTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of elements in Union Find Tree: ");
		int N = sc.nextInt();
		UnionFind uf = new UnionFind(N);
		while(true){
			System.out.println("Please enter the first node you want to combine:");
			int p = sc.nextInt();
			System.out.println("Please enter the second node you want to combine:");
			int q = sc.nextInt();
			// determine whether p and q is in the same group
			if (uf.connected(p,q)){
				System.out.println("Node："+ p +" Node: "+ q +" already in same group.");
				continue;
			}
			uf.union(p,q);
			System.out.println("Still have "+ uf.count() +" groups");
		}
	}
}
