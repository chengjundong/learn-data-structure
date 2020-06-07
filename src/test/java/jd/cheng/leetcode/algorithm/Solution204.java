package jd.cheng.leetcode.algorithm;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/count-primes/">Count Primes</a>
 */
public class Solution204 {

  // 厄拉多塞筛除法
  public int countPrimes(int n) {
    if(n < 2) return 0;

    // 先假设所有数字都是素数
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);

    // 检查数字，如果数字是某个数字的倍数，则不是素数
    for(int i=2; i < n; i++) {
      if(isPrime[i]) {
        // 排除所有i的倍数
        for(int j=2*i; j<n; j+=i) {
          isPrime[j] = false;
        }
      }
    }

    int result = 0;
    for(int i=2; i<n; i++) {
      if(isPrime[i]) result++;
    }

    return result;
  }

  @Test
  public void test() throws Exception {
    assertThat(this.countPrimes(0)).isEqualTo(0);
    assertThat(this.countPrimes(1)).isEqualTo(0);
    assertThat(this.countPrimes(2)).isEqualTo(0);
    assertThat(this.countPrimes(3)).isEqualTo(1);
    assertThat(this.countPrimes(10)).isEqualTo(4);
    assertThat(this.countPrimes(499979)).isEqualTo(41537);
  }
}
