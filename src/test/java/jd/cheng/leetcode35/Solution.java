package jd.cheng.leetcode35;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution {

	public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
	
	@Test
	public void test() {
		assertEquals(2, this.searchInsert(new int[] {1,3,5,6}, 5));
		assertEquals(1, this.searchInsert(new int[] {1,3,5,6}, 2));
		assertEquals(4, this.searchInsert(new int[] {1,3,5,6}, 7));
		assertEquals(0, this.searchInsert(new int[] {1,3,5,6}, 0));
		assertEquals(2, this.searchInsert(new int[] {1,4,6,7,8,9}, 6));
		assertEquals(6, this.searchInsert(new int[] {1,2,4,6,8,9,10}, 10));
		assertEquals(3, this.searchInsert(new int[] {3,5,7,9,10}, 8));
	}
}
