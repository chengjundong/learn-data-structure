package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/first-bad-version/">link</a>
 */
public class Solution278 {

  int badVersion;

  private boolean isBadVersion(int version) {
    return version == badVersion;
  }

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while(left < right) {
      int mid = left + (right-left)/2;
      if(isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid+1;
      }
    }

    return left;
  }

  @Test
  public void test() throws Exception {
    this.badVersion = 4;
    assertThat(firstBadVersion(5)).isEqualTo(4);
  }
}
