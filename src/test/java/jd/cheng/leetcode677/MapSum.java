package jd.cheng.leetcode677;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapSum {

	private static class Node {
		private final Map<Character, Node> nexts = new HashMap<>();
		private int val;
	}

	private final Node root;
	
	/** Initialize your data structure here. */
	public MapSum() {
		this.root = new Node();
	}

	public void insert(String key, int val) {
		if(key == null || key.trim().length() == 0) {
			throw new IllegalArgumentException("empty key!");
		}
		
		Node current = root;
		for(char c : key.toCharArray()) {
			Node node = current.nexts.get(c);
			if(null == node) {
				node = new Node();
				current.nexts.put(c, node);
			}
			current = node;
		}
		current.val = val;
	}

	public int sum(String prefix) {
		if(null == prefix || prefix.trim().length() == 0) {
			throw new IllegalArgumentException("empty prefix!");
		}
		
		Node current = root;
		for(char c : prefix.toCharArray()) {
			current = current.nexts.get(c);
			if(current == null) {
				// prefix not found, sum is 0
				return 0;
			}
		}
		
		// prefix found
		return this.sumInternal(current);
	}
	
	private int sumInternal(Node n) {
		int val = n.val;
		
		for (Entry<Character, Node> e : n.nexts.entrySet()) {
			val += sumInternal(e.getValue());
		}
		
		return val;
	}
	
	public int get(String key) {
		
		Node current = root;
		
		for(char c : key.toCharArray()) {
			current = current.nexts.get(c);
			if(current == null) {
				return 0;
			}
		}
		
		return current.val;
	}
	
	public static void main(String[] args) {
		MapSum ms = new MapSum();
		
		ms.insert("apple", 3);
		ms.insert("apply", 4);
		
		System.out.println(ms.sum("application"));
	}
}
