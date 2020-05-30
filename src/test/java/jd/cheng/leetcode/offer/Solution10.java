package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author jucheng
 */
public class Solution10 {

  public int fib(int n) {

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    map.put(1, 1);

    for(int i=2; i<=n; i++) {
      int x = map.get(i-1) + map.get(i-2);
      map.put(i, x % 1000000007);
    }

    return map.get(n);
  }

  @Test
  public void test() {
    assertThat(this.fib(5)).isEqualTo(5);
  }
}
