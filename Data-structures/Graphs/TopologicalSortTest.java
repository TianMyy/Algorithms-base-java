package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import stack.Stack;

public class TopologicalSortTest {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(TopologicalSortTest.class.getClassLoader().getResourceAsStream("topological_test.txt")));
		// read number of points
		int number = Integer.parseInt(reader.readLine());
		Digraph G = new Digraph(number);
		
		// read number of edges
		int roadNumber = Integer.parseInt(reader.readLine());
		
		// read edge, call addEdge function
		for (int i = 0; i < roadNumber; i++) {
			String line = reader.readLine();
			int p = Integer.parseInt(line.split(" ")[0]);
			int q = Integer.parseInt(line.split(" ")[1]);
			G.addEdge(p, q);
		}
		
		// create topological sort object
		TopologicalSort topo = new TopologicalSort(G);
		Stack<Integer> order = topo.order();
		
		// loop print
		StringBuilder sb = new StringBuilder();
		for (Integer v : order) {
			sb.append(v + "->");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
}
