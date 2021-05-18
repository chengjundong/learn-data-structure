package jd.cheng.leetcode.algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution349 {

	public int[] intersection(int[] nums1, int[] nums2) {
		
		if(null == nums1 || null == nums2) {
			return new int[0];
		}
		
		if(0 == nums1.length || 0 == nums2.length) {
			return new int[0];
		}
		
		Set<Integer> set = new HashSet<>();
		
		for(int n1 : nums1) {
			set.add(n1);
		}
		
		int length = nums1.length > nums2.length ?
				nums2.length : nums2.length;
		Set<Integer> resultSet = new HashSet<>(length);
		for(int n2 : nums2) {
			if(set.contains(n2)) {
				resultSet.add(n2);
			}
		}
		
		if(resultSet.isEmpty()) {
			return new int[0];
		}
		
		int[] result = new int[resultSet.size()];
		Iterator<Integer> iterator = resultSet.iterator();
		for(int i=0; iterator.hasNext(); i++) {
			result[i] = iterator.next();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] n1 = new int[] {4,9,5};
		int[] n2 = new int[] {9,4,9,8,4};
		
		int[] result = new Solution349().intersection(n1, n2);
		if(result != null) {			
			for (int i : result) {
				System.out.print(i+",");
			}
		}
	}
}
