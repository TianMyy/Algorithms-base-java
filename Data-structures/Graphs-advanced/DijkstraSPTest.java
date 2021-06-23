package graph_advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import queue.Queue;

public class DijkstraSPTest {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
		// read number of points, initiate EdgeWeightedDigraph()
		int number = Integer.parseInt(reader.readLine());
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(number);
		// read number of edges
		int edgeNumber = Integer.parseInt(reader.readLine());
		// read each edge, call addEdge function
		for (int i = 0; i < edgeNumber; i++) {
			String line = reader.readLine();
			int v = Integer.parseInt(line.split(" ")[0]);
			int w = Integer.parseInt(line.split(" ")[1]);
			double weight = Double.parseDouble(line.split(" ")[2]);
			G.addEdge(new DirectedEdge(v, w, weight));
		}
		// generate Dijkstra object based on EdgeWeightedDigraph G and start point 0
		DijkstraShortestPath dsp = new DijkstraShortestPath(G, 0);
		// get shortest path from 0->6
		Queue<DirectedEdge> edges = dsp.pathTo(6);
		// print
		for (DirectedEdge edge : edges) {
			System.out.println(edge.from() + "->" + edge.to() + "::" + edge.weight());
		}
	}
}
