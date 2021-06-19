package graph;

public class DepthFirstSearch {
	// index represent point, value indicate whether this point has been searched
	private boolean[] marked;
	// record how many points linked to point s
	private int count;
	
	public DepthFirstSearch(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.count = 0;
		dfs(G, s);
	}
	
	// use depth first search to find all linked points to v in the graph
	private void dfs(Graph g, int v) {
		// marked point v as searched
		marked[v] = true;
		for(Integer w : g.adj(v)) {
			if(!marked[w]) {
				dfs(g, w);
			}
		}
		count++;
	}
	
	// determine whether w and s is linked
	public boolean marked(int w) {
		return marked[w];
	}
	
	// get number of points linked to point s
	public int count() {
		return count;
	}
}
