package tree_advanced;

public class UnionFindTree {
	private int[] eleAndGroup;
	private int count;
	
	public UnionFindTree(int N) {
		this.eleAndGroup = new int[N];
		this.count = N;
		for(int i = 0; i < eleAndGroup.length; i++) {
			eleAndGroup[i] = i;
		}
	}
	
	// get count()
	public int count() {
		return count;
	}
	
	// find p's group
	public int find(int p) {
		while(p != eleAndGroup[p]) {
			p = eleAndGroup[p];
		}
		return p;
	}
	
	// determine if p and q are in the same group
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	// combine the group p in and q in
	public void union(int p, int q) {
		int proot = find(p);
		int qroot = find(q);
		if(proot == qroot) {
			return;
		}
		eleAndGroup[proot] = qroot;
		this.count--;
	}
}
