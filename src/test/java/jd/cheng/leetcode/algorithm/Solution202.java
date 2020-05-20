package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/happy-number/">happy number</a>
 */
public class Solution202 {

  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    return _isHappy(n, set);
  }

  private boolean _isHappy(int n, Set<Integer> set) {
    List<Integer> list = new LinkedList<>();

    long k = 1;
    while(n >= k) {
      list.add((int)(n/k) % 10);
      k *= 10;
    }

    int result = 0;
    for(int i : list) {
      result += i*i;
    }

    if(set.contains(result)) {
      return false;
    } else if(result == 1){
      return true;
    } else {
      set.add(result);
      return _isHappy(result, set);
    }
  }

  @Test
  public void test() throws Exception {
//    assertThat(this.isHappy(19)).isTrue();
//    assertThat(this.isHappy(18)).isFalse();
    assertThat(this.isHappy(1474573736)).isFalse();
  }
}
