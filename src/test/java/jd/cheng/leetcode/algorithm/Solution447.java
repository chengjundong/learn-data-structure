package jd.cheng.leetcode.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

/**
 * @author jucheng
 * @see <a href="https://leetcode-cn.com/problems/number-of-boomerangs/">link</a>
 */
public class Solution447 {

    public int numberOfBoomerangs(int[][] points) {
        if (null == points) return 0;

        Integer result = 0;
        for(int i=points.length-1; i>=0; i--) {
            // all distance to other points, starting from current
            Map<Integer, Integer> map = new HashMap<>();

            for(int j=points.length-1; j>=0; j--) {
                if(i != j) {
                    int dist = this.dist(points[i], points[j]);
                    map.put(dist, map.getOrDefault(dist, 0) + 1);
                }
            }

            // C(n,2) = n! / (2! * (n-2)!) = n * (n-1) / 2
            // however, we don't care the order the point, so we should multiple 2
            // then, the result = 2 * C(n,2) = n * (n-1)
            for(Map.Entry<Integer, Integer> e : map.entrySet()) {
                result += (e.getValue() * (e.getValue()-1));
            }
        }

        return result;
    }

    private int dist(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }

    @Test
    public void test() throws Exception {
        int[][] data = new int[][]{
                {0, 0},
                {1, 0},
                {2, 0}
        };

        assertThat(this.numberOfBoomerangs(data)).isEqualTo(2);
    }
}
