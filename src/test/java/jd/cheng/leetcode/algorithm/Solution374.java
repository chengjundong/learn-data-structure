package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower/">link</a>
 */
public class Solution374 {

  private int ans;

  public int guessNumber(int n) {
    return this._guessNumber(0, n, n);
  }

  public int _guessNumber(int left, int right, int n) {
    int mid = (right-left == 1 && right == n) ? n : left + (right-left)/2;
    int result = this.guess(mid);
    if(result == 0) return mid;
    else if(result == -1) return _guessNumber(left, mid, n);
    else return _guessNumber(mid, right, n);
  }

  private int guess(int num) {
    return Integer.compare(ans, num);
  }

  @Test
  public void test() throws Exception {
    this.ans = 6;
    assertThat(this.guessNumber(10)).isEqualTo(6);
    this.ans = 10;
    assertThat(this.guessNumber(10)).isEqualTo(10);
    this.ans = 0;
    assertThat(this.guessNumber(10)).isEqualTo(0);
    this.ans = 2147483647;
    assertThat(this.guessNumber(2147483647)).isEqualTo(2147483647);
  }
}
