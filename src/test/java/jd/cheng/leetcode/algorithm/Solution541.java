package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/reverse-string-ii/">link</a>
 */
public class Solution541 {

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    @Test
    public void test() {
        assertThat(this.reverseStr("abcdefg", 2)).isEqualTo("bacdfeg");
        assertThat(this.reverseStr("ab", 2)).isEqualTo("ba");
        assertThat(this.reverseStr("abc", 2)).isEqualTo("bac");
        assertThat(this.reverseStr("abcde", 2)).isEqualTo("bacde");
        assertThat(this.reverseStr("a", 2)).isEqualTo("a");
    }
}
