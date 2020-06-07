package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/">link</a>
 */
public class Solution40 {

  public int[] getLeastNumbers(int[] arr, int k) {
    Arrays.sort(arr);
    return Arrays.copyOf(arr, k);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.getLeastNumbers(new int[]{0,1,0,2,5,0}, 1)).containsExactly(0);
  }
}
