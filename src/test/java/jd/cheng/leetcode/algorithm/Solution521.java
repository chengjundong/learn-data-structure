package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/">link</a>
 */
public class Solution521 {

    public int findLUSlength(String a, String b) {
        if(a == null || b == null) return -1;
        else if(!a.equals(b)) return Math.max(a.length(), b.length());
        return -1;
    }

    @Test
    public void test() throws Exception {
        assertThat(this.findLUSlength("aaa", "bbb")).isEqualTo(3);
        assertThat(this.findLUSlength("ba", "baba")).isEqualTo(4);
        assertThat(this.findLUSlength("aaa", "aab")).isEqualTo(3);
        assertThat(this.findLUSlength("aaaa", "aaba")).isEqualTo(4);
        assertThat(this.findLUSlength("aaa", "aaa")).isEqualTo(-1);
        assertThat(this.findLUSlength("aaa", "")).isEqualTo(3);
        assertThat(this.findLUSlength("aaa", null)).isEqualTo(-1);
    }
}
