package graph;

import stack.Stack;

public class DepthFirstPaths {
	// index means points, value means whether this point already be searched 
	private boolean[] marked;
	// start point
	private int s;
	// index means start point, value means the last point from start point to this point' path
	private int[] edgeTo;
	
	public DepthFirstPaths(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.s = s;
		this.edgeTo = new int[G.V()];
		dfs(G, s);
	}
	
	// depth first search to find out all nearby points of point V
	private void dfs(Graph G, int v) {
		// marked v as searched;
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	// determine whether point w and point s have path
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	// find path from start point s and point v
	public Stack<Integer> pathTo(int v){
		if(!hasPathTo(v)) {
			return null;
		}
		// create stack object to save all points of path
		Stack<Integer> path = new Stack<>();
		// for loop from point v till find the start point
		for(int x = v; x != s; x = edgeTo[v]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
