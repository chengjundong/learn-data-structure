package jd.cheng.hashtable;

import java.util.Map.Entry;
import java.util.TreeMap;

public class JaredHashTable<K, V> {

	private TreeMap<K, V>[] table;
	private int length;
	private int elementCount;
	
	private int initCap = 16;
	private int upper = 10;
	private int lower = 2;
	
	@SuppressWarnings("unchecked")
	public JaredHashTable(int length) {
		this.table = new TreeMap[length];
		this.elementCount = 0;
		this.length = length;
		
		for(int i=length-1; i>=0; i--) {
			table[i] = new TreeMap<K, V>();
		}
	}
	
	/**
	 * init a size=16 hash table
	 */
	public JaredHashTable() {
		this(1 << 4);
	}
	
	/**
	 * @param key
	 * @return hashing value
	 */
	private int hashing(K key) {
		return (key.hashCode() & 0x7FFFFFFF) % length;
	}
	
	public int size() {
		return this.elementCount;
	}
	
	public V put(K key, V value) {
		TreeMap<K,V> map = table[this.hashing(key)];
		V result = null;
		if(map.containsKey(key)) {
			result = map.put(key, value);
		} else {
			elementCount++;
			result = map.put(key, value);
			if(elementCount >= upper * length) {
				resize(length << 1);
			}
		}
		
		return result;
	}
	
	public V remove(K key) {
		TreeMap<K,V> map = table[this.hashing(key)];
		V result = null;
		if(map.containsKey(key)) {
			elementCount--;
			result = map.remove(key);
		}
		
		if(elementCount < lower * length && lower * length >= initCap) {
			resize(length >> 1);
		}
		
		return result;
	}
	
	public V get(K key) {
		return table[this.hashing(key)].get(key);
	}
	
	public boolean contains(K key) {
		return table[this.hashing(key)].containsKey(key);
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		System.out.println(">>>>>>>>>> hash table resizing to: " + newSize);
		// init a new table
		TreeMap<K, V>[] newTable = new TreeMap[newSize];
		for(int i=newSize-1; i>=0; i--) {
			newTable[i] = new TreeMap<K, V>();
		}
		
		// re-hashing and copy elements
		for(int i=length-1; i>=0; i--) {
			TreeMap<K,V> map = this.table[i];
			for(Entry<K, V> e : map.entrySet()) {
				int hash = (e.getKey().hashCode() & 0x7FFFFFFF) % newSize;
				newTable[hash].put(e.getKey(), e.getValue());
			}
		}
		
		// change length
		this.length = newSize;
		
		// change table reference
		this.table = newTable;
	}
}
