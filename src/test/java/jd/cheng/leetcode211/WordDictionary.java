package jd.cheng.leetcode211;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordDictionary {

	private class Node {
		private boolean endOfWord;
		private Map<Character, Node> nexts = new HashMap<>();
		
		private Node put(Character c) {
			Node n = this.nexts.get(c);
			if(n == null) {
				n = new Node();
				this.nexts.put(c, n);
			}
			return n;
		}
	}
	
	private final Node root;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(null == word || word.length() == 0) {
        	throw new IllegalArgumentException("empty input!");
        }
        
        Node current = root;
        for(char c : word.toCharArray()) {
        	current = current.put(c);
        }
        
        if(!current.endOfWord) {
        	current.endOfWord = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	if(null == word || word.length() == 0) {
    		throw new IllegalArgumentException("empty input!");
        }
    	
        return this.searchByRecursion(root, word, 0);
    }
    
    private boolean searchByRecursion(Node current, String word, int index) {
    	// last one
    	if(index == word.length()) {
    		return current.endOfWord;
    	}
    	
    	if('.' == word.charAt(index)) {
    		// match all
    		for(Entry<Character, Node> e : current.nexts.entrySet()) {
    			if(this.searchByRecursion(e.getValue(), word, index+1)) {
    				return true;
    			}
    		}
    		return false;
    	} else {
    		// specific character
    		current = current.nexts.get(word.charAt(index));
    		return null != current && this.searchByRecursion(current, word, index+1);
    	}
    }
    
    public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
		
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		wd.addWord("med");
		wd.addWord("mae");
		wd.addWord("bid");
		wd.addWord("dead");
		
		System.out.println("pad:" + wd.search("pad"));
		System.out.println("bad:" + wd.search("bad"));
		System.out.println(".ad:" + wd.search(".ad"));
		System.out.println("b..:" + wd.search("b.."));
		System.out.println("bid.:" + wd.search("bid."));
		System.out.println("b.:" + wd.search("b."));
		System.out.println(".:" + wd.search("."));
	}
}
