package jd.cheng.map;

public interface JaredMap<K,V> {
	void put(K key, V value);
	V remove(K key);
	boolean contains(K key);
	V get(K key);
	void set(K key, V value);
	int size();
	boolean isEmpty();
}
