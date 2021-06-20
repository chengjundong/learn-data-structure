package jd.cheng.leetcode.weekly;

import java.util.Locale;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-246/problems/largest-odd-number-in-string/">largest-odd-number-in-string</a>
 */
public class Solution5788 {

    public String largestOddNumber(String num) {
        char[] cnum = num.toCharArray();
        int end = -1;
        for (int i = cnum.length - 1; i >= 0; i--) {
            int x = Character.getNumericValue(cnum[i]);
            if (x % 2 != 0) {
                end = i;
                break;
            }
        }

        if (end == -1) {
            return "";
        } else {
            char[] ans = new char[end + 1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = cnum[i];
            }
            return new String(ans);
        }
    }

    @Test
    public void test() {
        assertThat(largestOddNumber("52")).isEqualTo("5");
        assertThat(largestOddNumber("4206")).isEqualTo("");
        assertThat(largestOddNumber("35427")).isEqualTo("35427");
    }
}
