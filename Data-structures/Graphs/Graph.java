package graph;

import queue.Queue;

public class Graph {
	// number of points
	private final int V;
	// number of edges;
	private int E;
	// number of adjacency list
	private Queue<Integer>[] adj;
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new Queue[V];
		for(int i = 0; i < adj.length; i++) {
			adj[i] = new Queue<Integer>();
		}
	}
	
	// get number of points
	public int V() {
		return V;
	}
	
	// get number of edges
	public int E() {
		return E;
	}
	
	// add an edge v-w to the graph
	public void addEdge(int v, int w) {
		// there is no direction in graph without direction
		adj[v].enqueue(w);
		adj[w].enqueue(v);
		E++;
	}
	
	// get all nearby points for point v
	public Queue<Integer> adj(int v){
		return adj[v];
	}
}
