package jd.cheng.tree.union;

public class JaredQuickFind implements JaredUnionFind {

	private final int[] id;
	
	public JaredQuickFind(int size) {
		this.id = new int[size];
		// init id, no elements are not connected
		for(int i=size-1; i>=0; i--) {
			id[i] = i;
		}
	}
	
	@Override
	public void union(int p, int q) {
		int val = id[q];
		int ref = id[p];
		for(int i=id.length-1; i>=0; i--) {
			if(id[i] == ref) {
				id[i] = val;
			}
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	private int find(int x) {
		if(x < 0 || x >= id.length) {
			throw new IllegalArgumentException("invalid index");
		}
		return id[x];
	}

	@Override
	public int size() {
		return this.id.length;
	}

}
