package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] arr = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int[] zeroAndOneCount = this.getZeroAndOneCount(strs[i-1]);
            int zero = zeroAndOneCount[0];
            int one = zeroAndOneCount[1];
            for (int x = 0; x <= m; x++) {
                for (int y = 0; y <= n; y++) {
                    arr[i][x][y] = arr[i-1][x][y];
                    if(zero <= x && one <= y && arr[i][x][y] < 1 + arr[i-1][x-zero][y-one]) {
                        arr[i][x][y] = 1 + arr[i-1][x-zero][y-one];
                    }
                }
            }
        }

        return arr[strs.length][m][n];
    }

    private int[] getZeroAndOneCount(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    @Test
    public void test() {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        assertThat(this.findMaxForm(strs, m, n)).isEqualTo(4);

        strs = new String[]{"10", "0", "1"};
        m = 1;
        n = 1;
        assertThat(this.findMaxForm(strs, m, n)).isEqualTo(2);
    }
}
