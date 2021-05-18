package jd.cheng.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

public class Solution804 {

	public int uniqueMorseRepresentations(String[] words) {
		String[] table = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		
		Set<String> set = new HashSet<>();
		for(String word : words) {
			StringBuilder sb = new StringBuilder();
			for(char c : word.toCharArray()) {
				int index = ((int)c) - 97;
				sb.append(table[index]);
			}
			set.add(sb.toString());
		}
		
		return set.size();
    }
	
	public static void main(String[] args) {
		String[] words = new String[] {"gin", "zen", "gig", "msg"};
		System.out.println(new Solution804().uniqueMorseRepresentations(words));
	}
}
