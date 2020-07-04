package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @link <a href="https://leetcode-cn.com/problems/find-the-difference/">link</a>
 */
public class Solution389 {

  public char findTheDifference(String s, String t) {
    int[] sc = new int[26];
    for(int i=t.length()-1; i>=0; i--) {
      char c = t.charAt(i);
      sc[c-'a']++;
    }

    for(int i=s.length()-1; i>=0; i--) {
      char c = s.charAt(i);
      sc[c-'a']--;
    }

    for(int i=0; i<sc.length; i++) {
      if(sc[i] == 1) {
        return (char)(i+'a');
      }
    }

    return ' ';
  }

  @Test
  public void test() throws Exception {
    assertThat(this.findTheDifference("abcd","abcde")).isEqualTo('e');
    assertThat(this.findTheDifference("a","aa")).isEqualTo('a');
  }
}
