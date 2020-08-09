package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/detect-capital/">link</a>
 */
public class Solution520 {

    public boolean detectCapitalUse(String word) {
        if(null == word) return false;

        // all uppercase
        if(word.toUpperCase().equals(word)) {
            return true;
        }

        // all lowercase
        if(word.toLowerCase().equals(word)) {
            return true;
        }

        // capital
        if(word.equals(word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase())) {
            return true;
        }

        return false;
    }

    @Test
    public void test() throws Exception {
        assertThat(this.detectCapitalUse("USA")).isTrue();
        assertThat(this.detectCapitalUse("Google")).isTrue();
        assertThat(this.detectCapitalUse("leetcode")).isTrue();
        assertThat(this.detectCapitalUse("leeTcode")).isFalse();
        assertThat(this.detectCapitalUse("FlaG")).isFalse();
    }
}
