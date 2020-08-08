package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/fibonacci-number/">link</a>
 */
public class Solution509 {

    public int fib(int N) {
        if(N == 0) return 0;
        else if(N == 1) return 1;

        int[] arr = new int[N];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i < N; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[N-1] + arr[N-2];
    }

    @Test
    public void test() throws Exception {
        assertThat(this.fib(4)).isEqualTo(3);
    }
}
