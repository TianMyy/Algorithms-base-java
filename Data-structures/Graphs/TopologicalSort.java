package graph;

import stack.Stack;

public class TopologicalSort {
	private Stack<Integer> order;
	
	public TopologicalSort(Digraph G) {
		this.order = new Stack<Integer>();
		// generate cycle test object to test does graph has cycle
		DirectedCycle dc = new DirectedCycle(G);
		if(!dc.hasCycle()) {
			// if no cycle, use point sort based on depth first
			DepthFirstSort dfsort = new DepthFirstSort(G);
			order = dfsort.reversePost();
		}
	}
	
	// determine if graph G has cycle
	public boolean isCycle() {
		return order == null;
	}
	
	// get all the points of topological sort
	public Stack order() {
		return order;
	}
}
