package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/student-attendance-record-i/">link</a>
 */
public class Solution551 {
    public boolean checkRecord(String s) {
        if(s == null) return false;

        char[] chars = s.toCharArray();
        int absent = 0;
        int maxLater = 0;
        int curLater = 0;
        for(int i=0; i<s.length(); i++) {
            if(chars[i] == 'L') curLater++;
            else {
                maxLater = Math.max(curLater, maxLater);
                curLater = 0;

                if(chars[i] == 'A') absent++;
                if(absent > 1) return false;
            }
        }

        maxLater = Math.max(curLater, maxLater);
        return maxLater < 3;
    }

    @Test
    public void test() throws Exception {
        assertThat(checkRecord("PPALLP")).isTrue();
        assertThat(checkRecord("PPALLL")).isFalse();
    }
}
