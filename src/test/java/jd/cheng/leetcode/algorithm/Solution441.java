package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/arranging-coins/">link</a>
 */
public class Solution441 {

    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    @Test
    public void test() throws Exception {
        assertThat(this.arrangeCoins(8)).isEqualTo(3);
        assertThat(this.arrangeCoins(3)).isEqualTo(2);
        assertThat(this.arrangeCoins(1804289383)).isEqualTo(60070);
    }
}
