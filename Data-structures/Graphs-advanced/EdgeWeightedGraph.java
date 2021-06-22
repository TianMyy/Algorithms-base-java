package graph_advanced;

import queue.Queue;

public class EdgeWeightedGraph {
	// records number of points
	private final int V;
	// number of edges
	private int E;
	// adjacency list
	private Queue<Edge>[] adj;
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new Queue[V];
		// initiate empty queue in adj
		for(int i = 0; i < adj.length; i++) {
			adj[i] = new Queue<Edge>();
		}
	}
	
	// get number of points in graph
	public int V() {
		return V;
	}
	
	// get number of edges in graph
	public int E() {
		return E;
	}
	
	// add an edge e into weighted no-directed graph
	public void addEdge(Edge e) {
		// get point on
		int v = e.either();
		// get point two
		int w = e.other(v);
		// cause is no-directed graph, so edge e need to appear in two points' adajacency list
		adj[v].enqueue(e);
		adj[w].enqueue(e);
		
		E++;
	}
	
	// get all related edges of point v
	public Queue<Edge> adj(int v) {
		return adj[v];
	}
	
	// get all edges of weighted no-directed graph
	public Queue edges() {
		// create a queue to store all edges
		Queue<Edge> edges = new Queue<>();
		// loop points get adj of each point
		for(int i = 0; i < V; i++) {
			for(Edge e : adj(i)) {
				if(e.other(i) < i) {
					edges.enqueue(e);
				}
			}
		}
		return edges;
	}
}
