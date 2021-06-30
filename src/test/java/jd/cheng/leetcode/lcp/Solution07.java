package jd.cheng.leetcode.lcp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/chuan-di-xin-xi/">chuan-di-xin-xi</a>
 */
public class Solution07 {

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n-1];
    }

    @Test
    public void test() {
        int[][] relation = new int[][]{
                {0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}
        };
        int n = 5;
        int k = 3;

        assertThat(this.numWays(n, relation, k)).isEqualTo(3);
    }
}
