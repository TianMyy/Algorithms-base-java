package tree_advanced;

public class UnionFind {
	// records node element and group the element at
	private int[] eleAndGroup;
	// record number of groups of data in Union Find
	private int count;
	
	public UnionFind(int n) {
		// initiate number of groups
		this.count = n;
		this.eleAndGroup = new int[n];
		// initiate elements and group , let index as value of nodes, value of index as index
		for(int i = 0; i < eleAndGroup.length; i++) {
			eleAndGroup[i] = i;
		}
	}
	
	// get number of groups inside these data
	public int count() {
		return count;
	}
	
	// get the group of element p
	public int find(int p) {
		return eleAndGroup[p];
	}
	
	// determine whether p & q in the same group
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	// combine the group that p in with group q in
	public void union(int p, int q) {
		// if already in the same group, return
		if(connected(p, q)) {
			return;
		}
		int pgroup = find(p);
		int qgroup = find(q);
		// combination, let all elements in pgroup change group to qgroup
		for(int i = 0; i < eleAndGroup.length; i++) {
			if(eleAndGroup[i] == pgroup) {
				eleAndGroup[i] = qgroup;
			}
		}
		// number of group -1
		this.count--;
	}
	
}
