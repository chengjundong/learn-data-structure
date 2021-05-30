package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @since <a href="https://leetcode-cn.com/problems/unique-paths/">unique-paths</a>
 */
public class Solution62 {

  public int uniquePaths(int m, int n) {
    if (m == 1 || n == 1) {
      return 1;
    }

    int[][] arr = new int[m][n];

    // horizontal
    for (int i = 0; i < m; i++) {
      arr[i][0] = 1;
    }

    // vertical
    for (int i = 0; i < n; i++) {
      arr[0][i] = 1;
    }

    for (int x = 1; x < m; x++) {
      for (int y = 1; y < n; y++) {
        arr[x][y] = arr[x - 1][y] + arr[x][y - 1];
      }
    }

    return arr[m - 1][n - 1];
  }

  @Test
  public void test() {
    int m = 1, n = 1;
    assertThat(uniquePaths(m,n)).isEqualTo(1);

    m=100;
    n=1;
    assertThat(uniquePaths(m,n)).isEqualTo(1);

    m=1;
    n=100;
    assertThat(uniquePaths(m,n)).isEqualTo(1);

    m=2;
    n=2;
    assertThat(uniquePaths(m,n)).isEqualTo(2);

    m=3;
    n=3;
    assertThat(uniquePaths(m,n)).isEqualTo(6);

    m = 3;
    n = 7;
    assertThat(uniquePaths(m, n)).isEqualTo(28);
  }
}
