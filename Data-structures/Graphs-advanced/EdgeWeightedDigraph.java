package graph_advanced;

import queue.Queue;

public class EdgeWeightedDigraph {
	// records number of points
	private final int V;
	// number of edges
	private int E;
	// adjacency list
	private Queue<DirectedEdge>[] adj;
	
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new Queue[V];
		// initiate empty queue in adj
		for(int i = 0; i < adj.length; i++) {
			adj[i] = new Queue<DirectedEdge>();
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
	public void addEdge(DirectedEdge e) {
		// get point start
		int v = e.from();
		// cause is directed graph, so edge e appear in v's adjacency list
		adj[v].enqueue(e);
		
		E++;
	}
	
	// get all related edges of point v
	public Queue<DirectedEdge> adj(int v) {
		return adj[v];
	}
	
	// get all edges of weighted directed graph
	public Queue<DirectedEdge> edges() {
		// create a queue to store all edges
		Queue<DirectedEdge> edges = new Queue<>();
		// loop points get adj of each point
		for(int i = 0; i < V; i++) {
			for(DirectedEdge e : adj(i)) {
				edges.enqueue(e);
			}
		}
		return edges;
	}
}
