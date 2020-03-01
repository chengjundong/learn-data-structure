package jd.cheng.map;

import jd.cheng.tree.binarysearchtree.JaredBinarySearchTree;

public class JaredTreeMap<K extends Comparable<K>, V> implements JaredMap<K, V> {

	private JaredBinarySearchTree<K, V> tree;
	
	public JaredTreeMap() {
		this.tree = new JaredBinarySearchTree<>();
	}
	
	@Override
	public void put(K key, V value) {
		if(!this.contains(key)) {
			this.tree.add(key, value);
		}
	}

	@Override
	public V remove(K key) {
		V result = tree.get(key);
		if(null != result) {
			this.tree.remove(key);
			return result;
		} else {
			return null;
		}
	}

	@Override
	public boolean contains(K key) {
		return tree.contains(key);
	}

	@Override
	public V get(K key) {
		return tree.get(key);
	}

	@Override
	public void set(K key, V value) {
		tree.set(key, value);
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
