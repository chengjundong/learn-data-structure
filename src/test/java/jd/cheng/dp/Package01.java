package jd.cheng.dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 */
public class Package01 {

    /**
     * 有一个背包，最大重量为C
     * 现有0 ~ n-1个物品，重量为w(i)，价值为v(i)
     * 请问，如何在不超过背包重量限制的情况下，使得背包价值最大
     * ----------------------------------------------
     * 函数 F(n, C) 为求解将n个物品放入最大重量为C的背包使得其价值最大的函数
     * <p>
     * 对于物品i，有如下两种表达式
     * 不放入 A = F(i-1, C)
     * 放入 B = v(i) + F(i-1, C-w(i)) （放入后价值增加，剩余重量减少）
     * <p>
     * 于是，对于是否放入i，变成了一个求极值的问题，即状态转移方程如下
     * F(i, C) = MAX(A, B) = MAX(F(i-1, C), v(i) + F(i-1, C-w(i)))
     */
    @Test
    public void test1() {
        // C = 5
        // v1 = 6; w1 = 1
        // v2 = 10; w2 = 2
        // v3 = 12; w3 = 3
        // v4 = 100; w3 = 5
        // v5 = 1000; w3 = 10
        // expect: 100
        int C = 5;
        int[] v = new int[]{6, 10, 12, 100, 1000};
        int[] w = new int[]{1, 2, 3, 5, 10};

        int[][] x = new int[v.length][C + 1];

        // fill the 1st row
        for (int i = w[0]; i <= C; i++) {
            x[0][i] = v[0];
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j <= C; j++) {
                if (j >= w[i]) {
                    x[i][j] = Math.max(x[i - 1][j], v[i] + x[i - 1][j-w[i]]);
                } else {
                    x[i][j] = x[i - 1][j];
                }
            }
        }

        assertThat(x[v.length-1][C]).isEqualTo(100);
    }
}
