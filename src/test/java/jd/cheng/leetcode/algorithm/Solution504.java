package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/base-7/">link</a>
 */
public class Solution504 {

    public String convertToBase7(int num) {
        if(num == 0) return "0";

        int n = Math.abs(num);

        int size = (int) (Math.log(n) / Math.log(7)) + 1;
        StringBuffer sb = num < 0 ? new StringBuffer("-") : new StringBuffer();

        for (int i = size - 1; i >= 0; i--) {
            double k = Math.pow(7, i);
            int x = (int) (n / k);
            sb.append(String.valueOf(x));
            n -= x * k;
        }

        return sb.toString();
    }

    @Test
    public void test() throws Exception {
        assertThat(this.convertToBase7(100)).isEqualTo("202");
        assertThat(this.convertToBase7(-7)).isEqualTo("-10");
        assertThat(this.convertToBase7(0)).isEqualTo("0");
    }
}
