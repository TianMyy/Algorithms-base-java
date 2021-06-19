package tree_advanced;

import java.util.Scanner;

public class UFTreeWeightedTest {
	public static void main(String[] args) {
		UFTreeWeighted ufw = new UFTreeWeighted(5);
        System.out.println("As default, there are " + ufw.count() + " groups");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter first element：");
            int p = sc.nextInt();
            System.out.println("Enter second element：");
            int q = sc.nextInt();

            if (ufw.connected(p,q)){
                System.out.println(p +" and "+ q + " already in the same group");
                continue;
            }

            ufw.union(p,q);
            System.out.println("There still " + ufw.count() + "groups");
        }
	}
}
