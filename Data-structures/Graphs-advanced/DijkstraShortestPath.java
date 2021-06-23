package graph_advanced;

import priority.IndexMinPriorityQueue;
import queue.Queue;

public class DijkstraShortestPath {
	// index -> points, value -> the last edge of shorted path from s to current point
	private DirectedEdge[] edgeTo;
	// index -> points, value -> sum weight of SP from s to current point
	private double[] distTo;
	// store cross-cutting edges of point in tree and out tree
	private IndexMinPriorityQueue<Double> pq;
	
	public DijkstraShortestPath(EdgeWeightedDigraph G, int s) {
		this.edgeTo = new DirectedEdge[G.V()];
		this.distTo = new double[G.V()];
		for(int i = 0; i < distTo.length; i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		this.pq = new IndexMinPriorityQueue<>(G.V());
		distTo[0] = 0.0;
		pq.insert(0,  0.0);
		while(!pq.isEmpty()) {
			// relax the point in G
			relax(G, pq.delMin());
		}
	}
	
	private void relax(EdgeWeightedDigraph G, int v) {
		for(DirectedEdge e : G.adj(v)) {
			// get end of edge
			int w = e.to();
			// if weight of s->w more than s->v+e.weight(), modify path of s->w
			// :edgeTo[w]=e, and modify distTo[v] distTo[v]+e.weight()
			if(distTo[w] > distTo[v]+e.weight()) {
				edgeTo[w] = e;
				distTo[w] = distTo[v]+e.weight();
				
				// if w already in priority queue, reset weight of w
				if(pq.contains(w)) {
					pq.changeItem(w, distTo[w]);
				}else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}
	
	// get sum weight from s to v
	public double distTo(int v) {
		return distTo[v];
	}
	
	// determine whether s->v can reach
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	// search all edges of SP from s->w
	public Queue<DirectedEdge> pathTo(int v){
		// if s cannot reach v, return null
		if(!hasPathTo(v)) {
			return null;
		}
		Queue<DirectedEdge> edges = new Queue<>();
		// from v, reverse search till find start point s
		DirectedEdge e = null;
		while(true) {
			e = edgeTo[v];
			if(e == null) {
				break;
			}
			edges.enqueue(e);
			v = e.from();
		}
		return edges;
	}
}
