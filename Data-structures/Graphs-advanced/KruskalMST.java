package graph_advanced;

import priority.MinPriorityQueue;
import queue.Queue;
import tree_advanced.UFTreeWeighted;

public class KruskalMST {
	// store edges of mst
	private Queue<Edge> mst;
	// index ->points, uf.connected(v, w) to determine whether w and c in the same tree
	// uf.union(v,w) can combine two trees
	private UFTreeWeighted uf;
	// store all edges of graph, use minimum priority queue to sort edges based on weight
	private MinPriorityQueue<Edge> pq;
	
	public KruskalMST(EdgeWeightedGraph G) {
		this.mst = new Queue<Edge>();
		this.uf = new UFTreeWeighted(G.V());
		this.pq = new MinPriorityQueue<>(G.E()+1);
		for(Edge e : G.edges()) {
			pq.insert(e);
		}
		
		// if priority != null && edges of mst less than v-1, continue loop
		while(!pq.isEmpty() && mst.size() < G.V()-1) {
			// get lowest weighted edge
			Edge e = pq.delMin();
			// get two points v and w of edge e
			int v = e.either();
			int w = e.other(v);
			// if connected, cannot add this edge to mst, it will lead to cycle
			// if not connected, combine tree v and w at, add this edge to mst
			if(uf.connected(v, w)) {
				continue;
			}
			uf.union(v, w);
			mst.enqueue(e);
		}
	}
	
	public Queue<Edge> edges() {
		return mst;
	}
}
