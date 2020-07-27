package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/island-perimeter/">link</a>
 */
public class Solution463 {

  public int islandPerimeter(int[][] grid) {
    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          int lines = 4;
          if (i > 0 && grid[i - 1][j] == 1) // up
            lines--;
          if (i < grid.length - 1 && grid[i + 1][j] == 1) // down
            lines--;
          if (j > 0 && grid[i][j - 1] == 1) // left
            lines--;
          if (j < grid[0].length - 1 && grid[i][j + 1] == 1) // right
            lines--;
          sum += lines;
        }
      }
    }
    return sum;
  }

  @Test
  public void test() throws Exception {
    int[][] grid = new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0},
    };
    assertThat(this.islandPerimeter(grid)).isEqualTo(4);
  }
}
