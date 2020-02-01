package jd.cheng.map;

import jd.cheng.tree.binarysearchtree.JaredBinarySearchTree;

public class JaredTreeMap<K extends Comparable<K>, V> implements JaredMap<K, V> {

	private JaredBinarySearchTree<JaredEntry<K, V>> tree;
	
	public JaredTreeMap() {
		this.tree = new JaredBinarySearchTree<>();
	}
	
	@Override
	public void put(K key, V value) {
		if(!this.contains(key)) {
			this.tree.add(new JaredEntry<>(key, value));
		}
	}

	@Override
	public V remove(K key) {
		JaredEntry<K, V> result = tree.get(new JaredEntry<>(key, null));
		if(null != result) {
			this.tree.remove(result);
			return result.getValue();
		} else {
			return null;
		}
	}

	@Override
	public boolean contains(K key) {
		return tree.contains(new JaredEntry<>(key, null));
	}

	@Override
	public V get(K key) {
		JaredEntry<K, V> result = tree.get(new JaredEntry<>(key, null));
		return null == result ? null : result.getValue();
	}

	@Override
	public void set(K key, V value) {
		JaredEntry<K, V> result = tree.get(new JaredEntry<>(key, null));
		if(null != result) {
			result.setValue(value);
		}
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
