package tree_advanced;

public class UFTreeWeighted {
	private int[] eleAndGroup;
	private int count;
	// store every node related tree's node quantity
	private int[] size;
	public UFTreeWeighted(int N) {
		this.eleAndGroup = new int[N];
		this.count = N;
		for(int i = 0; i < eleAndGroup.length; i++) {
			eleAndGroup[i] = i;
		}
		this.size = new int[N];
		for(int i = 0; i < size.length; i++) {
			size[i] = i;
		}
	}
	
	// get number of groups
	public int count() {
		return count;
	}
	
	// determine whether p and q in the same group
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	// group of p
	public int find(int p) {
		while(p !=  eleAndGroup[p]) {
			p = eleAndGroup[p];
		}
		return p;
	}
	
	// combine pgroup and qgroup
	public void union(int p, int q) {
		int proot = find(p);
		int qroot = find(q);
		
		if(proot == qroot) {
			return;
		}
		
		if(size[proot] < size[qroot]) {
			eleAndGroup[proot] = qroot;
			size[qroot] += size[proot];
		}else {
			eleAndGroup[qroot] = proot;
			size[proot] += size[qroot];
		}
		this.count--;
	}	
}
