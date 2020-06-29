package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/ransom-note/">link</a>
 */
public class Solution383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> ransomMap = new HashMap<>();
    Map<Character, Integer> magMap = new HashMap<>();

    for(int i=ransomNote.length()-1; i >=0; i--) {
      char c = ransomNote.charAt(i);
      if(ransomMap.containsKey(c)) {
        ransomMap.put(c, ransomMap.get(c)+1);
      } else {
        ransomMap.put(c, 1);
      }
    }

    for(int i=magazine.length()-1; i >=0; i--) {
      char c = magazine.charAt(i);
      if(magMap.containsKey(c)) {
        magMap.put(c, magMap.get(c)+1);
      } else {
        magMap.put(c, 1);
      }
    }

    for(Entry<Character, Integer> re : ransomMap.entrySet()) {
      if(magMap.containsKey(re.getKey())) {
        if(magMap.get(re.getKey()) < re.getValue()) {
          return false;
        }
      } else {
        return false;
      }
    }

    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.canConstruct("aa", "aab")).isTrue();
    assertThat(this.canConstruct("aa", "aaab")).isTrue();
    assertThat(this.canConstruct("aa", "ab")).isFalse();
    assertThat(this.canConstruct("aa", "aa")).isTrue();
  }
}
