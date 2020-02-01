package jd.cheng.map;

import jd.cheng.tree.binarysearchtree.JaredBinarySearchTree;

public class JaredTreeSet<T extends Comparable<T>> implements JaredSet<T> {

	private JaredBinarySearchTree<T> tree;
	
	public JaredTreeSet() {
		tree = new JaredBinarySearchTree<>();
	}

	@Override
	public void add(T e) {
		tree.add(e);
	}

	@Override
	public void remove(T e) {
		tree.remove(e);
	}

	@Override
	public boolean contains(T e) {
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
