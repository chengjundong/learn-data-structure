package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/valid-palindrome-ii/">valid palindrome 2</a>
 */
public class Solution680 {

  public boolean validPalindrome(String s) {
    int low = 0;
    int high = s.length() - 1;

    while(low < high) {
      if(s.charAt(low) == s.charAt(high)) {
        low++;
        high--;
        continue;
      } else {
        // two flags to indicate if remove left or remove right can make it palindrome
        boolean removeL = true;
        boolean removeR = true;

        // try remove left
        TryRemoveLeft: for(int _low = low+1, _high = high; _low < _high; _low++, _high--) {
          if(s.charAt(_low) != s.charAt(_high)) {
            removeL = false;
            break TryRemoveLeft;
          }
        }

        if(removeL) return true;

        // try remove right
        TryRemoveRight: for(int _low = low, _high = high-1; _low < _high; _low++, _high--) {
          if(s.charAt(_low) != s.charAt(_high)) {
            removeR = false;
            break TryRemoveRight;
          }
        }

        return removeR;
      }
    }

    return true;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.validPalindrome("aba")).isTrue();
    assertThat(this.validPalindrome("abca")).isTrue();
  }
}
