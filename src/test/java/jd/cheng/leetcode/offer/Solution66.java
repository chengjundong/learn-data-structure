package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/">link</a>
 */
public class Solution66 {

  // 对称遍历求解
  public int[] constructArr(int[] a) {
    if(a == null || a.length == 0) return a;
    int[] b = new int[a.length];

    // 下三角
    b[0] = 1;
    for (int i = 1; i < a.length; i++) {
      b[i] = b[i - 1] * a[i - 1];
    }

    // 上三角
    int t = 1;
    for (int i = a.length - 2; i >= 0; i--) {
      t = t * a[i + 1];
      b[i] = b[i] * t;
    }

    return b;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.constructArr(new int[]{1, 2, 3, 4, 5})).containsExactly(120, 60, 40, 30, 24);
  }
}
