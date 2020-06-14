package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/">link</a>
 */
public class Solution65 {

  public int add(int a, int b) {
    if(b == 0) return a;
    return add(a^b, (a&b)<<1);
  }

  @Test
  public void test() throws Exception {
    assertThat(this.add(1,1)).isEqualTo(2);
    assertThat(this.add(4,1)).isEqualTo(5);
  }
}
