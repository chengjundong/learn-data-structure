package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/number-of-segments-in-a-string/">link</a>
 */
public class Solution434 {

  public int countSegments(String s) {
    if(s == null || s.trim().equals("")) {
      return 0;
    }

    int count = 0;
    boolean foundAWord = false;
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(c == ' ') {
        // the index find a space, reset the flag
        foundAWord = false;
        continue;
      } else if(foundAWord){
        // the index is inside a word
        continue;
      } else {
        // the index just find a word
        count++;
        foundAWord = true;
      }
    }

    return count;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.countSegments("Hello, my name is John")).isEqualTo(5);
    assertThat(this.countSegments("  Hello, my name is John  ")).isEqualTo(5);
    assertThat(this.countSegments("Hello, my name is               John")).isEqualTo(5);
  }
}
