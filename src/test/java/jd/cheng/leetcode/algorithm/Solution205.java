package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/isomorphic-strings/">同构字符串</a>
 */
public class Solution205 {

  public boolean isIsomorphic(String s, String t) {
    if(s == null || t == null || s.length() != t.length()) return false;

    Map<Character, Character> smap = new HashMap<>();
    Map<Character, Character> tmap = new HashMap<>();
    for(int i=s.length()-1; i >=0; i--) {
      char cs = s.charAt(i);
      char ct = t.charAt(i);
      if(smap.containsKey(cs) && smap.get(cs) != ct) {
        return false;
      }

      if(tmap.containsKey(ct) && tmap.get(ct) != cs) {
        return false;
      }

      smap.put(cs, ct);
      tmap.put(ct, cs);
    }

    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isIsomorphic("ab","aa")).isFalse();
    assertThat(this.isIsomorphic("egg","add")).isTrue();
    assertThat(this.isIsomorphic("foo","bar")).isFalse();
    assertThat(this.isIsomorphic("paper","title")).isTrue();
  }
}
