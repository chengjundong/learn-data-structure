package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/reshape-the-matrix/">link</a>
 */
public class Solution566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null) return nums;
        if(nums.length * nums[0].length != r*c) return nums;

        int[][] ans = new int[r][c];

        Queue<Integer> queue = new ArrayDeque<>(r*c);
        for(int x=0; x < nums.length; x++) {
            for(int y=0; y < nums[x].length; y++) {
                queue.offer(nums[x][y]);
            }
        }

        for(int x=0; x < r; x++) {
            for(int y=0; y < c; y++) {
                ans[x][y] = queue.poll();
            }
        }

        return ans;
    }

    @Test
    public void test() throws Exception {
        int[][] nums = new int[][]{{1,2}, {3,4}};
        int[][] result = this.matrixReshape(nums, 1, 4);
        assertThat(result).hasSize(1);
        assertThat(result[0]).contains(1,2,3,4);
    }
}
