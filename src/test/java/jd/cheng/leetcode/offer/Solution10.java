package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/">斐波那契数列</a>
 * @see <a href="https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/">青蛙跳台阶问题</a>
 */
public class Solution10 {

  public int fib(int n) {

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    map.put(1, 1);

    for (int i = 2; i <= n; i++) {
      int x = map.get(i - 1) + map.get(i - 2);
      map.put(i, x % 1000000007);
    }

    return map.get(n);
  }

  public int numWays(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    map.put(1, 1);

    for (int i = 2; i <= n; i++) {
      int x = map.get(i - 1) + map.get(i - 2);
      map.put(i, x % 1000000007);
    }

    return map.get(n);
  }

  @Test
  public void test() {
    assertThat(this.fib(5)).isEqualTo(5);
    assertThat(this.numWays(7)).isEqualTo(21);
  }
}
