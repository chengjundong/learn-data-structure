package jd.cheng.leetcod53;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Solution {

	public int maxSubArray(int[] nums) {

		int n = nums.length;
		int currSum = nums[0], maxSum = nums[0];

		for (int i = 1; i < n; ++i) {
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}

	@Test
	public void test() {
		assertThat(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })).isEqualTo(6);
		assertThat(maxSubArray(new int[] { -1 })).isEqualTo(-1);
		assertThat(maxSubArray(new int[] { -2, -1 })).isEqualTo(-1);
	}
}
