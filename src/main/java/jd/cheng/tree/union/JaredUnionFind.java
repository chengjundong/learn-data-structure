package jd.cheng.tree.union;

public interface JaredUnionFind {

	/**
	 * union these two indexes
	 * 
	 * @param p -- index
	 * @param q -- index
	 */
	void union(int p, int q);
	
	/**
	 * to find whether these two indexes are connected
	 * 
	 * @param p -- index
	 * @param q -- index
	 * @return
	 */
	boolean isConnected(int p, int q);
	
	int size();
}
