package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/partition-equal-subset-sum/">partition-equal-subset-sum</a>
 */
public class Solution416 {

    public boolean canPartition(int[] nums) {
        int count = 0;
        for(int i=nums.length-1;i>=0;i--) {
            count += nums[i];
        }
        if(count % 2 != 0) {
            return false;
        }

        int half = count / 2;
        int[][] arr = new int[2][half+1];
        for(int i=1;i<=half;i++) {
            if(i >= nums[0]) {
                arr[0][i] = nums[0];
            }
        }

        for(int i=1;i<nums.length;i++) {
            int v = nums[i];
            for(int j=1;j<=half;j++) {
                if(j >= v) {
                    arr[i%2][j] = Math.max(arr[(i-1)%2][j], v + arr[(i-1)%2][j-v]);
                } else {
                    arr[i%2][j] = arr[(i-1)%2][j];
                }
                if(arr[i%2][j] == half) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,5,11,5};
        assertThat(this.canPartition(nums)).isTrue();

        nums = new int[]{1,5,5,11};
        assertThat(this.canPartition(nums)).isTrue();

        nums = new int[]{1,2,3,5};
        assertThat(this.canPartition(nums)).isFalse();

        nums = new int[]{1};
        assertThat(this.canPartition(nums)).isFalse();
    }
}
