package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/perfect-number/">link</a>
 */
public class Solution507 {

    public boolean checkPerfectNumber(int num) {
        if(num <= 1) return false;
        int sum = 0;
        for(int i=1; i * i <= num; i++) {
            if(num % i == 0) {
                sum += i;
                sum += num/i;
            }
        }

        return num == sum - num;
    }

    @Test
    public void test() throws Exception {
        assertThat(this.checkPerfectNumber(28)).isTrue();
        assertThat(this.checkPerfectNumber(2)).isFalse();
        assertThat(this.checkPerfectNumber(27)).isFalse();
    }
}
