package graph;

import stack.Stack;

public class DepthFirstSort {
	private boolean[] marked;
	// use stack to store points
	private Stack<Integer> reversePost;
	
	public DepthFirstSort(Digraph G) {
		this.marked = new boolean[G.V()];
		this.reversePost = new Stack<Integer>();
		for(int i = 0; i < G.V(); i++) {
			// if current point didn't searched, then search it
			if(!marked[i]) {
				dfs(G, i);
			}
		}
	}
	
	// based on depth first search, generate sequential list of points 
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		// for each point v's adjacency list, get each point w
		for(Integer w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
		reversePost.push(v);
	}
	
	// get sequential list of points
	public Stack reversePost() {
		return reversePost;
	}
}
