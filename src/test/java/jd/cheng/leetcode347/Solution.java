package jd.cheng.leetcode347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


public class Solution {

	public List<Integer> topKFrequent(int[] nums, int k) {
		// 0. basic validation
		if(k <= 0) {
			throw new IllegalArgumentException("invalid k");
		}
		if(null == nums || nums.length == 0) {
			throw new IllegalArgumentException("empty nums");
		}
		
		// 1. collect frequency of input elements
		Map<Integer, Integer> fMap = this.collectFrequency(nums);
		
		// 2. create a priority queue
		PriorityQueue<Entry<Integer, Integer>> q = new PriorityQueue<>(fMap.size(), this.comparator());
		
		// 3. put map to queue
		for(Entry<Integer, Integer> entry : fMap.entrySet()) {
			q.add(entry);
		}
		
		// 4. collect result
		List<Integer> result = new ArrayList<>(k);
		for(int i=k; i>0; i--) {
			result.add(q.remove().getKey());
		}
		
        return result;
    }
	
	private Map<Integer, Integer> collectFrequency(int[] nums) {
		
		Map<Integer, Integer> result = new HashMap<>(nums.length);
		
		for(int i=nums.length; i>0; i--) {
			int n = nums[i-1];
			Integer e = result.get(n);
			if(null == e) {
				// no exist, put it to map, frequency is 1
				result.put(n, 1);
			} else {
				// exist, frequency + 1
				result.put(n, e+1);
			}
		}
		
		return result;
	}
	
	/**
	 * entry.key - number
	 * entry.value - frequencey
	 * 
	 * 1. compare frequency
	 * 2. if frequencies are equal, then compare the number
	 * 
	 * @return
	 */
	private Comparator<Entry<Integer, Integer>> comparator() {
		return new Comparator<Map.Entry<Integer,Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				Integer diff = o2.getValue() - o1.getValue();
				return diff == 0 ? o2.getKey()-o1.getKey() : diff;
			}
			
			@Override
			public boolean equals(Object obj) {
				return super.equals(obj);
			}
		};
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,1,1,3,3,4,4,2,2};
		int k = 2;
		
		List<Integer> result = new Solution().topKFrequent(nums, k);
		System.out.println(result);
	}
}