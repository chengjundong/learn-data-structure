package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/">旋转数组的最小数字</a>
 */
public class Solution11 {

  public int minArray(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      return -1;
    }
    if (numbers.length == 1) {
      return numbers[0];
    }

    boolean found = false;
    int result = 0;
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i + 1] < numbers[i]) {
        found = true;
        result = numbers[i + 1];
        break;
      }
    }

    return found ? result : numbers[0];
  }

  @Test
  public void test() throws Exception {
    assertThat(this.minArray(new int[]{3, 4, 5, 1, 2})).isEqualTo(1);
    assertThat(this.minArray(new int[]{2, 2, 2, 0, 1})).isEqualTo(0);
    assertThat(this.minArray(new int[]{1, 2, 3})).isEqualTo(1);
  }
}
