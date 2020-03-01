package jd.cheng.map;

import jd.cheng.tree.binarysearchtree.JaredBinarySearchTree;

public class JaredTreeSet<K extends Comparable<K>> implements JaredSet<K> {

	private JaredBinarySearchTree<K, Object> tree;
	
	public JaredTreeSet() {
		tree = new JaredBinarySearchTree<>();
	}

	@Override
	public void add(K e) {
		tree.add(e, new Object());
	}

	@Override
	public void remove(K e) {
		tree.remove(e);
	}

	@Override
	public boolean contains(K e) {
		return tree.contains(e);
	}

	@Override
	public int size() {
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}
}
