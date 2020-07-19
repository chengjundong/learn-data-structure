package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/string-compression/">link</a>
 */
public class Solution443 {

    public int compress(char[] chars) {
        if(null == chars) return 0;

        int cur = 0;
        int ctn = 1;
        int length = 0;
        for(int i=1; i<chars.length; i++) {
            if(chars[cur] == chars[i]) {
                ctn++;
            } else if(ctn == 1) {
                // update array
                chars[length++] = chars[cur];
                // move cur pointer
                cur = i;
            } else {
                // update array
                chars[length++] = chars[cur];
                String sc = String.valueOf(ctn);
                for(char c : sc.toCharArray()) {
                    chars[length++] = c;
                }
                // move cur pointer
                cur = i;
                // reset ctn
                ctn = 1;
            }
        }

        // update array
        if(ctn > 1) {
            // update array
            chars[length++] = chars[cur];
            String sc = String.valueOf(ctn);
            for(char c : sc.toCharArray()) {
                chars[length++] = c;
            }
        } else if(ctn == 1) {
            // update array
            chars[length++] = chars[cur];
        }

        return length;
    }

    @Test
    public void test() throws Exception {
        char[] data = new char[]{'a','a','b','b','c','c','c'};
        assertThat(this.compress(data)).isEqualTo(6);
        assertThat(data).containsExactly('a','2','b','2','c','3','c');

        data = new char[]{'a','b','c','d'};
        assertThat(this.compress(data)).isEqualTo(4);
        assertThat(data).containsExactly('a','b','c','d');

        data = new char[]{'a','a','a','d'};
        assertThat(this.compress(data)).isEqualTo(3);
        assertThat(data).containsExactly('a','3','d','d');

        data = new char[]{'a','d','d','d'};
        assertThat(this.compress(data)).isEqualTo(3);
        assertThat(data).containsExactly('a','d','3','d');

        data = new char[]{'a','d','d','d','d','d','d','d','d','d','d','d','d'};
        assertThat(this.compress(data)).isEqualTo(4);
        assertThat(data).containsExactly('a','d','1','2','d','d','d','d','d','d','d','d','d');

        data = new char[]{'a','a','a','b','a'};
        assertThat(this.compress(data)).isEqualTo(4);
        assertThat(data).containsExactly('a','3','b','a','a');
    }
}
