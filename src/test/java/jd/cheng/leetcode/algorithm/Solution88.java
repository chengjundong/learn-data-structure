package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * 
 * @author jucheng
 * @since https://leetcode-cn.com/problems/merge-sorted-array/
 *
 */
public class Solution88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// two get pointers for nums1 and nums2
	    int p1 = m - 1;
	    int p2 = n - 1;
	    // set pointer for nums1
	    int p = m + n - 1;

	    // while there are still elements to compare
	    while ((p1 >= 0) && (p2 >= 0))
	      // compare two elements from nums1 and nums2 
	      // and add the largest one in nums1 
	      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

	    // add missing elements from nums2
	    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
	
	@Test
	public void test() {
		int[] n1 = new int[] {1,2,3,0,0,0};
		int[] n2 = new int[] {2,5,6};
		
		this.merge(n1, 3, n2, 3);
		
		assertThat(n1).containsExactly(1,2,2,3,5,6);
		
		n1 = new int[] {4,0,0,0,0,0};
		n2 = new int[] {1,2,3,5,6};
		
		this.merge(n1, 1, n2, 5);
		
		assertThat(n1).containsExactly(1,2,3,4,5,6);
		
		n1 = new int[] {0};
		n2 = new int[] {1};
		
		this.merge(n1, 0, n2, 1);
		
		assertThat(n1).containsExactly(1);
	}
}
