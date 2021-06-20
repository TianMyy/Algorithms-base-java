package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DirectedCycleTest {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(DirectedCycleTest.class.getClassLoader().getResourceAsStream("cycle_test.txt")));
		// read number of points, build graph
		int number = Integer.parseInt(reader.readLine());
		Digraph G = new Digraph(number);
		//  read number of edges
		int roadNumber = Integer.parseInt(reader.readLine());
		// read edge, call addEdge method
		for (int i = 0; i < roadNumber; i++) {
			String line = reader.readLine();
			int p = Integer.parseInt(line.split(" ")[0]);
			int q = Integer.parseInt(line.split(" ")[1]);
			G.addEdge(p, q);
		}
		DirectedCycle cycle = new DirectedCycle(G);
		// test does the graph has cycle
		System.out.println(cycle.hasCycle());
	}
}
