package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/longest-palindrome/">link</a>
 */
public class Solution409 {

  public int longestPalindrome(String s) {
    if(s == null) return 0;

    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for(Character c : s.toCharArray()) {
      if(map.containsKey(c)) {
        ans += 2;
        map.remove(c);
      } else {
        map.put(c, 1);
      }
    }

    return map.isEmpty() ? ans : ans+1;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.longestPalindrome("abccccdd")).isEqualTo(7);
  }
}
