package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">best time to buy&sell stock</a>
 */
public class Solution121 {

  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int result = 0;

    for(int i=0; i<prices.length; i++) {
      if(prices[i] < min) {
        min = prices[i];
      } else if(prices[i] - min > result) {
        result = prices[i] - min;
      }
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(maxProfit(new int[]{7,1,5,3,6,4})).isEqualTo(5);
  }
}
