package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">Best time to
 * buy&seller stock 2</a>
 */
public class Solution122 {

  public int maxProfit(int[] prices) {
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }

  @Test
  public void test() throws Exception {
    assertThat(maxProfit(new int[]{1, 2, 3})).isEqualTo(2);
    assertThat(maxProfit(new int[]{1, 2, 3, 1, 3})).isEqualTo(4);
    assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(7);
  }
}
