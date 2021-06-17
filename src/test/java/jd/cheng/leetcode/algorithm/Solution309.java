package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">best-time-to-buy-and-sell-stock-with-cooldown</a>
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] result = new int[n][3];
        result[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            result[i][0] = Math.max(result[i-1][0], result[i-1][2]-prices[i]);
            result[i][1] = result[i-1][0] + prices[i];
            result[i][2] = Math.max(result[i-1][1], result[i-1][2]);
        }

        return Math.max(result[n-1][1], result[n-1][2]);
    }

    @Test
    public void test() {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        assertThat(maxProfit(prices)).isEqualTo(3);

        prices = new int[]{1};
        assertThat(maxProfit(prices)).isEqualTo(0);

        prices = new int[]{};
        assertThat(maxProfit(prices)).isEqualTo(0);
    }
}
