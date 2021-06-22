package graph_advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import queue.Queue;

public class KruskalMSTTest {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(KruskalMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
		// read number of points
		int number = Integer.parseInt(reader.readLine());
		EdgeWeightedGraph G = new EdgeWeightedGraph(number);
		// read number of edges
		int edgeNumber = Integer.parseInt(reader.readLine());
		// read each edge, call addEdge
		for (int i = 0; i < edgeNumber; i++) {
			String line = reader.readLine();
			int v = Integer.parseInt(line.split(" ")[0]);
			int w = Integer.parseInt(line.split(" ")[1]);
			double weight = Double.parseDouble(line.split(" ")[2]);
			G.addEdge(new Edge(v, w, weight));
		}
		// KruskalMST object
		KruskalMST mst = new KruskalMST(G);
		// get edges of MST
		Queue<Edge> edges = mst.edges();
		// print
		for (Edge edge : edges) {
			if (edge!=null){
				System.out.println(edge.either() + "-" + edge.other(edge.either()) + "::" + edge.weight());
			}
		}
	}
}
