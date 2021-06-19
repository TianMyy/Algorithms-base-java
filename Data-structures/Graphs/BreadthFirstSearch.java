package graph;

import queue.Queue;

public class BreadthFirstSearch {
	private boolean[] marked;
	private int count;
	private Queue<Integer> waitSearch;
	public BreadthFirstSearch(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.count = 0;
		this.waitSearch = new Queue<Integer>();
		
		bfs(G, s);
	}
	
	// use breath first search to find all nearby points of v in graph
	private void bfs(Graph G, int v) {
		marked[v] = true;
		// let point v enqueue to wait for search
		waitSearch.enqueue(v);
		// if the queue not empty, dequeue a point to search
		while(!waitSearch.isEmpty()) {
			int temp = waitSearch.dequeue();
			for(int w : G.adj(temp)) {
				if(!marked[w]) {
					bfs(G, w);
				}
			}
		}
		count++;
	}
	
	// determine whether w and top point s connected
	public boolean marked(int w) {
		return marked[w];
	}
	
	// get number of points linked to top point s
	public int count() {
		return count;
	}
}
