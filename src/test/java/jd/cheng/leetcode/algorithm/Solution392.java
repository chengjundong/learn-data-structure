package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/is-subsequence/">link</a>
 */
public class Solution392 {

  public boolean isSubsequence(String s, String t) {
    int i = 0;

    for(int j=0; i<s.length() && j<t.length(); ) {
      char sc = s.charAt(i);
      char tc = t.charAt(j);
      if(sc == tc) {
        i++;
        j++;
      } else {
        j++;
      }
    }

    return i == s.length();
  }

  @Test
  public void test() throws Exception {
    assertThat(this.isSubsequence("abc", "abc")).isTrue();
    assertThat(this.isSubsequence("abc", "acbc")).isTrue();
    assertThat(this.isSubsequence("abc", "acbce")).isTrue();
    assertThat(this.isSubsequence("abb", "acbce")).isFalse();
    assertThat(this.isSubsequence("abc", "ahbgdc")).isTrue();
    assertThat(this.isSubsequence("axc", "ahbgdc")).isFalse();
    assertThat(this.isSubsequence("abc", "dafdoijfaoijdffadfahbdasfafdasdfsdsfasdfdagdcadfawfadsfadfasdfadsfasdf")).isTrue();
    assertThat(this.isSubsequence("abc", "adfasdfadfasdfasdfhbdafadfdfdasfagdcdaofijadsoifjioajdfoljsadoifjasodfqounfasdf")).isTrue();
  }
}
