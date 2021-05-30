package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author jucheng
 * @since <a href="https://leetcode-cn.com/problems/unique-paths-ii/">unique-paths-ii</a>
 */
public class Solution63 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid == null) {
      return 0;
    }

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    int[][] arr = new int[m][n];

    // horizontal
    for (int i = 0; i < m; i++) {
      if(obstacleGrid[i][0] == 1) {
        break;
      } else {
        arr[i][0] = 1;
      }
    }

    // vertical
    for (int i = 0; i < n; i++) {
      if(obstacleGrid[0][i] == 1) {
        break;
      } else {
        arr[0][i] = 1;
      }
    }

    for (int x = 1; x < m; x++) {
      for (int y = 1; y < n; y++) {
        if(obstacleGrid[x][y] == 1) {
          continue;
        } else {
          arr[x][y] = arr[x - 1][y] + arr[x][y - 1];
        }
      }
    }

    return arr[m - 1][n - 1];
  }

  @Test
  public void test() {
    int[][] obstacleGrid = new int[][]{
        {0,0},
        {0,0},
    };
    assertThat(uniquePathsWithObstacles(obstacleGrid)).isEqualTo(2);

    obstacleGrid = new int[][]{
        {0,0},
    };
    assertThat(uniquePathsWithObstacles(obstacleGrid)).isEqualTo(1);

    obstacleGrid = new int[][]{
        {0,1,0},
    };
    assertThat(uniquePathsWithObstacles(obstacleGrid)).isEqualTo(0);

    obstacleGrid = new int[][]{
        {0,0,0},
        {0,1,0},
        {0,0,0},
    };
    assertThat(uniquePathsWithObstacles(obstacleGrid)).isEqualTo(2);
  }
}
