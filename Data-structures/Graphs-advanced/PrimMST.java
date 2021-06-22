package graph_advanced;

import priority.IndexMinPriorityQueue;
import queue.Queue;

public class PrimMST {
	// index -> points, value -> shortest edge between curr point and minimum spanning tree(MST) 
	private Edge[] edgeTo;
	// index -> points, value -> weight of shortest edge between curr point and MST
	private double[] distTo;
	// index -> points, if current point already in tree, value = true, instead value = false
	private boolean[] marked;
	// store cross-cutting edge between 2q	point in tree and out tree
	private IndexMinPriorityQueue<Double> pq;
	
	// based on a weighted no-directed graph, create MST calculate object
	public PrimMST(EdgeWeightedGraph G) {
		// create an edge array has the same number of G.V(), indicates edges
		this.edgeTo = new Edge[G.V()];
		this.distTo = new double[G.V()];
		// initiate values in distTo as infinite large, means didn't exist this value
		for(int i = 0; i < distTo.length; i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		this.marked = new boolean[G.V()];
		this.pq = new IndexMinPriorityQueue<>(G.V());
		
		// default add 0 as the first point in MST
		distTo[0] = 0.0;
		// use point 0 and weight 0 initiate pq;
		pq.insert(0, 0.0);
		while(!pq.isEmpty()) {
			// find lowest weight cross-cutting edge related points, add to MST
			visit(G, pq.delMin());
		}
	}
	
	// add point to MST and update values in distTo
	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		// for loop v's adjacency list
		for(Edge e : G.adj(v)) {
			// one point is v, find another
			int w = e.other(v);
			if(marked[w]) {
				continue;
			}
			// if weight of v-w less than current distTo[w], update value
			if(e.weight() < distTo[w]) {
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w)) {
					pq.changeItem(w, e.weight());
				}else {
					pq.insert(w, e.weight());
				}
			}
		}
	}
	
	// get all edges of MST
	public Queue<Edge> edges(){
		// create queue
		Queue<Edge> edges = new Queue<>();
		for(int i = 0; i < edgeTo.length; i++) {
			if(edgeTo[i] != null) {
				edges.enqueue(edgeTo[i]);
			}
		}
		return edges;
	}
}
