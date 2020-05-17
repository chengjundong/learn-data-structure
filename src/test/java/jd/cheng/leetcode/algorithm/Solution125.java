package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome/">Valid Palindrome</a>
 */
public class Solution125 {

  public boolean isPalindrome(String s) {
    if (null == s) {
      return false;
    }

    int head = 0;
    int tail = s.length() - 1;

    while(head < tail) {
      // find head
      while(head < s.length() && !isLetterOrNumber(s.charAt(head))) {
        head++;
      }
      if(head >= s.length()) {
        break;
      }
      char hc = s.charAt(head);

      // find tail
      while(tail >= 0 && !isLetterOrNumber(s.charAt(tail))) {
        tail--;
      }
      if(tail < 0) {
        break;
      }
      char ht = s.charAt(tail);

      // compare
      if(String.valueOf(ht).equalsIgnoreCase(String.valueOf(hc))) {
        head++;
        tail--;
        continue;
      } else  {
        return false;
      }
    }

    return true;
  }

  private boolean isLetterOrNumber(char c) {
    return (c >= 48 && c <= 57) // digit
        || (c >= 65 && c <= 90) // upper case alphabet
        || (c >= 97 && c <= 122); // lower case alphabet
  }

  @Test
  public void test() throws Exception {
    assertThat(isPalindrome("level")).isTrue();
    assertThat(isPalindrome("A man, a plan, a canal: Panama")).isTrue();
    assertThat(isPalindrome(".,")).isTrue();
  }
}
