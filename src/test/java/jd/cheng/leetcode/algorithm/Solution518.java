package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/coin-change-2/">coin-change-2</a>
 */
public class Solution518 {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount+1];
    dp[0] = 1;

    for(int coin : coins) {
      for(int i = coin; i <= amount; i++) {
        dp[i] += dp[i-coin];
      }
    }

    return dp[amount];
  }

  @Test
  public void test() {
    int amount = 5;
    int[] coins = new int[]{1,2,5};

    assertThat(change(amount, coins)).isEqualTo(4);
  }
}
