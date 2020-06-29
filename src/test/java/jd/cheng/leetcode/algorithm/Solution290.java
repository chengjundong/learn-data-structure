package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/word-pattern/">link</a>
 */
public class Solution290 {

  public boolean wordPattern(String pattern, String str) {
    if(null == pattern || null == str) return false;
    String[] strs = str.split(" ");
    if(pattern.length() != strs.length) return false;

    Map<Character, String> map_p = new HashMap<>();
    Map<String, Character> map_str = new HashMap<>();

    for(int i=0; i<strs.length; i++) {
      Character c = pattern.charAt(i);
      String s = strs[i];

      map_p.putIfAbsent(c, s);
      map_str.putIfAbsent(s, c);

      if(!Objects.equals(map_p.get(c), s)) {
        return false;
      } else if(!Objects.equals(map_str.get(s), c)) {
        return false;
      }
    }

    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.wordPattern("abba", "dog cat cat dog")).isTrue();
    assertThat(this.wordPattern("abba", "dog cat cat cat")).isFalse();
    assertThat(this.wordPattern("aba", "dog cat cat cat")).isFalse();
    assertThat(this.wordPattern("abba", "dog cat cat")).isFalse();
  }
}
