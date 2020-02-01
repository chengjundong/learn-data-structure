package jd.cheng.map;

import jd.cheng.linkedlist.JaredLinkedList;

public class JaredLinkedListMap<K extends Comparable<K>, V> implements JaredMap<K, V> {

	private JaredLinkedList<JaredEntry<K, V>> list;
	
	public JaredLinkedListMap() {
		this.list = new JaredLinkedList<>();
	}

	@Override
	public void put(K key, V value) {
		if(!this.contains(key)) {
			list.addLast(new JaredEntry<>(key, value));
		}
	}

	@Override
	public V remove(K key) {
		JaredEntry<K,V> entry = list.getByValue(new JaredEntry<>(key, null));
		if(null == entry) {
			return null;
		} else {
			list.removeByValue(entry);
			return entry.getValue();
		}
	}

	@Override
	public boolean contains(K key) {
		return list.contains(new JaredEntry<>(key, null));
	}

	@Override
	public V get(K key) {
		JaredEntry<K,V> entry = list.getByValue(new JaredEntry<>(key, null));
		if(null == entry) {
			return null;
		} else {
			return entry.getValue();
		}
	}

	@Override
	public void set(K key, V value) {
		JaredEntry<K,V> entry = list.getByValue(new JaredEntry<>(key, null));
		if(null != entry) {
			entry.setValue(value);
		}
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
