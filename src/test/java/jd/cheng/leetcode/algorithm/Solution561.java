package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/array-partition-i/">link</a>
 */
public class Solution561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length; i+=2) {
            ans += Math.min(nums[i], nums[i+1]);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1,2,3,4};
        assertThat(this.arrayPairSum(arr)).isEqualTo(4);
        arr = new int[]{1,5,10,15};
        assertThat(this.arrayPairSum(arr)).isEqualTo(11);
    }
}
