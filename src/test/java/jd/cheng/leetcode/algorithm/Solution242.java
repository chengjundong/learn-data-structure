package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/valid-anagram/">link</a>
 */
public class Solution242 {

  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;
    int[] arr = new int[26];

    for(int i=0; i<s.length(); i++) {
      arr[s.charAt(i)-'a']++;
      arr[t.charAt(i)-'a']--;
    }

    for(int n : arr) {
      if(n != 0) return false;
    }

    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isAnagram("cat","rat")).isFalse();
    assertThat(this.isAnagram("rats","rat")).isFalse();
    assertThat(this.isAnagram("rat","rats")).isFalse();
    assertThat(this.isAnagram("anagram","nagaram")).isTrue();
  }
}
