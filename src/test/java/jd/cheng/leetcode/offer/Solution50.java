package jd.cheng.leetcode.offer;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/">link</a>
 */
public class Solution50 {

  public char firstUniqChar(String s) {
    LinkedHashSet<Character> set = new LinkedHashSet<>();
    Set<Character> blackList = new HashSet<>();
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(blackList.contains(c)) continue;

      if(set.contains(c)) {
        set.remove(c);
        blackList.add(c);
      } else {
        set.add(c);
      }
    }

    return set.isEmpty() ? ' ' : set.iterator().next();
  }

  @Test
  public void test() throws Exception {
    assertThat(this.firstUniqChar("abaccdeff")).isEqualTo('b');
    assertThat(this.firstUniqChar("")).isEqualTo(' ');
  }
}
