package jd.cheng.tree.avl;

import jd.cheng.map.JaredMap;

public class JaredAVLMap<K extends Comparable<K>, V> implements JaredMap<K, V> {

	private JaredAVL<K, V> avl = new JaredAVL<>();

	@Override
	public void put(K key, V value) {
		avl.add(key, value);
	}

	@Override
	public V remove(K key) {
		return avl.remove(key);
	}

	@Override
	public boolean contains(K key) {
		return avl.contains(key);
	}

	@Override
	public V get(K key) {
		return avl.get(key);
	}

	@Override
	public void set(K key, V value) {
		avl.set(key, value);
	}

	@Override
	public int size() {
		return avl.size();
	}

	@Override
	public boolean isEmpty() {
		return avl.isEmpty();
	}
	
}
