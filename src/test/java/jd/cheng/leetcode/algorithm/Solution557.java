package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/">link</a>
 */
public class Solution557 {

    public String reverseWords(String s) {
        if(s == null || s.trim().length() == 0) return s;

        String[] words = s.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for(String word : words) {
            sj.add(this.revert(word));
        }

        return sj.toString();
    }

    private String revert(String w) {
        char[] c = new char[w.length()];
        for(int i=w.length()-1,j=0; i>=0; i--,j++) {
            c[j] = w.charAt(i);
        }
        return new String(c);
    }

    @Test
    public void test() {
        assertThat(this.reverseWords("Let's take LeetCode contest")).isEqualTo("s'teL ekat edoCteeL tsetnoc");
        assertThat(this.reverseWords("Let's")).isEqualTo("s'teL");
        assertThat(this.reverseWords(" ")).isEqualTo(" ");
    }
}
