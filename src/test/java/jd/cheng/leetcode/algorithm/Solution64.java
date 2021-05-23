package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">minimum-path-sum</a>
 */
public class Solution64 {

  int[][] dp;

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    dp = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];

    // calculate row
    for (int i = 1; i < grid[0].length; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }

    // calculate col
    for (int i = 1; i < grid.length; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[dp.length - 1][dp[0].length - 1];
  }

  @Test
  public void test() throws Exception {
    int[][] grid = null;
    assertThat(this.minPathSum(grid)).isEqualTo(0);

    grid = new int[][]{};
    assertThat(this.minPathSum(grid)).isEqualTo(0);

    grid = new int[][]{
        {}
    };
    assertThat(this.minPathSum(grid)).isEqualTo(0);

    grid = new int[][]{
        {1, 2, 3}
    };

    assertThat(this.minPathSum(grid)).isEqualTo(6);

    grid = new int[][]{
        {1},
        {2},
        {3},
        {4}
    };

    assertThat(this.minPathSum(grid)).isEqualTo(10);

    grid = new int[][]{
        {1, 2, 3},
        {4, 5, 6}
    };

    assertThat(this.minPathSum(grid)).isEqualTo(12);

    grid = new int[][]{
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };

    assertThat(this.minPathSum(grid)).isEqualTo(7);
  }
}
