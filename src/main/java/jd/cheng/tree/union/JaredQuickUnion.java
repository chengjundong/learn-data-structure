package jd.cheng.tree.union;

public class JaredQuickUnion implements JaredUnionFind {

	private final int[] parent;
	
	public JaredQuickUnion(int size) {
		this.parent = new int[size];
		for(int i=size-1; i>=0; i--) {
			this.parent[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		Index resultP = this.getParent(new Index(p, 0));
		Index resultQ = this.getParent(new Index(q, 0));
		
		if(resultP.val != resultQ.val) {
			if(resultP.depth > resultQ.depth) {
				parent[q] = p;
			} else {
				parent[p] = q;
			}
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return this.getParent(p) == this.getParent(q);
	}
	
	private int getParent(int p) {
		return parent[p] == p ? p : getParent(parent[p]);
	}
	
	private Index getParent(Index p) {
		return parent[p.val] == p.val ? p : getParent(new Index(parent[p.val], p.depth+1));
	}

	@Override
	public int size() {
		return this.parent.length;
	}
	
	private static final class Index {
		private int val;
		private int depth;
		
		public Index(int val, int depth) {
			this.val = val;
			this.depth = depth;
		}
	}
}
