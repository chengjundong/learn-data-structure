package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/">打印从1到最大的n位数</a>
 */
public class Solution17 {

  public int[] printNumbers(int n) {
    int length = (int) (Math.pow(10, n) - 1);
    int[] result = new int[length];
    for(int i=0; i<result.length; i++) {
      result[i] = i+1;
    }
    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.printNumbers(1)).containsExactly(1,2,3,4,5,6,7,8,9);
  }
}
