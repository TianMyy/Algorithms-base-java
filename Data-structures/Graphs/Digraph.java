package graph;

import queue.Queue;

public class Digraph {
	// record number of points
	private final int V;
	// record number of edges
	private int E;
	private Queue[] adj;
	
	public Digraph(int V) {
		this.adj = new Queue[V];
		this.E = 0;
		this.V = V;
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
	
	// add an edge to directed graph : v->w
	public void addEdge(int v, int w) {
		E++;
		adj[v].enqueue(w);
	}
	
	// get all points linked to edges point out from v
	public Queue<Integer> adj(int v){
		return adj[v];
	}
	
	// reverse graph of it
	private Digraph reverse() {
		// create directed graph object
		Digraph r = new Digraph(V);
		// get each points from loop 0->v-1
		for(int i = 0; i < V; i++) {
			for(int w : adj(i)) {
				r.addEdge(w, i);
			}
		}
		return r;
	}
}
