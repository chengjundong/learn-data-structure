package jd.cheng.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class JaredTrie {

	private class Node {
		private boolean endOfWord;
		private Map<Character, Node> nexts = new HashMap<>();

		private Node(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
		
		private Node() {
			this(false);
		}

		private boolean isEndOfWord() {
			return endOfWord;
		}

		private void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
		
		private Node put(Character c) {
			Node n = this.nexts.get(c);
			if(n == null) {
				n = new Node();
				this.nexts.put(c, n);
			}
			return n;
		}
	}
	
	private Node root;
	private int size;
	
	public JaredTrie() {
		this.root = new Node();
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void add(String word) {
		// make word to char array and put to tree
		Node current = root;
		for(char c : word.toCharArray()) {
			current = current.put(c);
		}
		// if current isn't marked as the end of word
		// we think we add a new word to the directory
		if(!current.isEndOfWord()) {			
			current.setEndOfWord(true);
			size++;
		}
	}
	
	public boolean contains(String word) {
		if(word == null || word.trim().equals("")) {
			return false;
		}
		
		return this.contains(root, word, 0);
	}
	
	private boolean contains(Node current, String word, int index) {
		char c = word.charAt(index);
		Node node = current.nexts.get(c);
		
		if(word.length() - 1 == index) {
			return null == node ? false : node.isEndOfWord();
		} else {
			return null == node ? false : this.contains(node, word, index+1);
		}
	}
	
	public boolean containsPrefix(String prefix) {
		if(prefix == null || prefix.trim().equals("")) {
			return false;
		}
		
		Node current = root;
		for(char c : prefix.toCharArray()) {
			current = current.nexts.get(c);
			if(null == current) {
				return false;
			}
		}
		
		return true;
	}
}
