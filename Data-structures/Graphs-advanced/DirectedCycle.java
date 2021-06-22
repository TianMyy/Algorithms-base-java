package graph_advanced;

public class DirectedCycle {
	private boolean[] marked;
	// record does graph has cycle
	private boolean hasCycle;
	// index indicate point, use stack thinking to records is current point at directed path which is searching
	private boolean[] onStack;
	
	public DirectedCycle(Digraph G) {
		this.marked = new boolean[G.V()];
		// default situation: no cycle
		this.hasCycle =  false;
		this.onStack = new boolean[G.V()];
		// loop every points in graph
		for(int i = 0; i < G.V(); i++) {
			// if current point not marked, search it
			if(!marked[i]) {
				dfs(G, i);
			}
		}
	}
	
	// based on depth first search, test if the graph has cycle
	private void dfs(Digraph G, int v) {
		// mark v as searched
		marked[v] = true;
		// put current point into stack
		onStack[v] = true;
		// search
		for(Integer w : G.adj(v)) {
			// if w not searched before, still use dfs to search
			if(!marked[w]) {
				dfs(G, w);
			}
			// if w already in onStack, means it is on searching, but search again, means has cycle
			if(onStack[w]) {
				hasCycle = true;
				return;
			}
		}
		// pop current point out
		onStack[v] = false;
	}
	
	// determine if current graph has cycle
	public boolean hasCycle() {
		return hasCycle;
	}
}
